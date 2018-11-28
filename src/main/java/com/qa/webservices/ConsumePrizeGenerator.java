package com.qa.webservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.AccountConstants;

@RestController
public class ConsumePrizeGenerator implements IConsumePrizeGenerator {
	
	  @Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public String getPrize(String accountNumber) {
		return restTemplate.getForObject(
				AccountConstants.IP + AccountConstants.PRIZE_GEN_PORT + AccountConstants.GET_PRIZE_PATH + accountNumber,
				String.class);


	   }


}
