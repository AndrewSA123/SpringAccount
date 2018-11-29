package com.qa.restTests;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constantsTests.Constants;
import com.qa.persistence.domain.Account;
import com.qa.rest.AccountEndpoint;
import com.qa.service.IAccountService;
import com.qa.webservices.IConsumePrizeGenerator;



public class AccountEndpointTests {
	
	
	
	@InjectMocks
	private AccountEndpoint endpoint;
	
	@Mock
	private IAccountService service;
	
	@Mock
	private IConsumePrizeGenerator prizeGen;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllAccounts() {
		Account MockAccount = new Account();
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(MockAccount);
		Mockito.when(service.getAllAccounts()).thenReturn(accounts);
		Assert.assertEquals(accounts, endpoint.getAllAccounts());
	}
	
	@Test
	public void testFindAccount() {
		Account MockAccount = new Account();
		Mockito.when(service.findAccount(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Assert.assertEquals(Optional.ofNullable(MockAccount), endpoint.findAccount(MockAccount.getID()));
		
	}


}
