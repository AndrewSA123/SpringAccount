package com.qa.restTests;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constantsTests.Constants;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;
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
	@Mock
	private IAccountRepo repo;

	private Account MockAccount;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockAccount = new Account();
	}

	@After
	public void tearDown() {
		MockAccount = null;
	}

	@Test
	public void testGetAllAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(MockAccount);
		Mockito.when(service.getAllAccounts()).thenReturn(accounts);
		Assert.assertEquals(accounts, endpoint.getAllAccounts());
	}

	@Test
	public void testFindAccount() {
		Mockito.when(service.findAccount(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Assert.assertEquals(Optional.ofNullable(MockAccount), endpoint.findAccount(MockAccount.getID()));
	}

	@Test
	public void testCreateAccount() {
		Mockito.when(service.createAccount(MockAccount)).thenReturn(MockAccount);
		Assert.assertEquals(MockAccount, endpoint.createAccount(MockAccount));
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(service.deleteAccount(MockAccount.getID())).thenReturn(Constants.MOCK_STRING);
		Assert.assertEquals(Constants.MOCK_STRING, endpoint.deleteAccount(MockAccount.getID()));
	}

	@Test
	public void testUpdateAccount() {
		Mockito.when(service.updateAccount(MockAccount.getID(), MockAccount)).thenReturn(Constants.MOCK_STRING);
		Assert.assertEquals(Constants.MOCK_STRING, endpoint.updateAccount(MockAccount.getID(), MockAccount));
	}

	@Test
	public void testGetPrize() {
		Mockito.when(prizeGen.getPrize(MockAccount.getAccountNumber())).thenReturn(Constants.MOCK_STRING);
		Assert.assertEquals(Constants.MOCK_STRING, endpoint.getPrize(MockAccount.getAccountNumber()));
	}

}
