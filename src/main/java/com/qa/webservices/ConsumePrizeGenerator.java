package com.qa.webservices;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.qa.constants.AccountConstants;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;

@RestController
public class ConsumePrizeGenerator implements IConsumePrizeGenerator {
	
	  @Autowired
	  private RestTemplate restTemplate;
	  
	  @Autowired
	  private JmsTemplate jmsTemplate;
	  
	  @Autowired
	  private IAccountRepo repo;
	  

	@GetMapping
	public String getPrize(String accountNumber) {
		String prize= restTemplate.getForObject(
				AccountConstants.PrizeGenIP + AccountConstants.PRIZE_GEN_PORT + AccountConstants.GET_PRIZE_PATH
						+ accountNumber,
				String.class);
		List<Account> accounts = Lists.newArrayList(repo.findAll());
		Account account=accounts.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst().get();
		account.setPrize(prize);
		
		com.qa.ATS.Account accountToSend = new com.qa.ATS.Account();
		accountToSend.setID(account.getID());
		accountToSend.setAccountNumber(account.getAccountNumber());
		accountToSend.setAccountType(account.getAccountType());
		accountToSend.setFirstName(account.getFirstName());
		accountToSend.setLastName(account.getLastName());
		accountToSend.setPrize(account.getPrize());
		
		jmsTemplate.convertAndSend("accountQueue",accountToSend);

		return prize;
	   }


}
