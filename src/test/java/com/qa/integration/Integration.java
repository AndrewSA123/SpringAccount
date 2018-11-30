package com.qa.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.persistence.domain.Account;
import com.qa.rest.IAccountEndpoint;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Integration {
	
	@Autowired
	private IAccountEndpoint endpoint;
	
	@Test
	public void findAccountTest() {
		Account acc = new Account("Tom", "Bamf","0","");
		endpoint.createAccount(acc);
		assertEquals(acc.getFirstName(),endpoint.findAccount(acc.getID()).get().getFirstName());
		assertEquals(acc.getLastName(),endpoint.findAccount(acc.getID()).get().getLastName());
		assertEquals(acc.getPrize(),endpoint.findAccount(acc.getID()).get().getPrize());
		assertEquals(acc.getAccountNumber(),endpoint.findAccount(acc.getID()).get().getAccountNumber());
		}
	
	@Test
	public void createTest() {
		Account acc = new Account("Tom", "Bamf","0","");
		assertEquals(acc, endpoint.createAccount(acc));		
	}


}