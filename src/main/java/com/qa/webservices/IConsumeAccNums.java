package com.qa.webservices;

import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Account;

@RestController
public interface IConsumeAccNums {
	
	String getAccountNumber(Account account);

}
