package com.qa.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.AccountConstants;
import com.qa.persistence.domain.Account;

@RestController
@CrossOrigin
public class ConsumeAccountNumber implements IConsumeAccNums {
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public String getAccountNumber(Account account) {

		return restTemplate.postForObject(AccountConstants.AccountNumGenIP + AccountConstants.NUM_GEN_PORT
				+ AccountConstants.GET_ACCOUNT_NUMBER_PATH + account.getAccountType(), account,
				String.class);
	   }
	

}
