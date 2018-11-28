package com.qa.webservices;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IConsumePrizeGenerator {
	
	String getPrize(String accountNumber);

}
