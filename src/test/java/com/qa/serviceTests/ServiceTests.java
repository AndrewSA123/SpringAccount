package com.qa.serviceTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.constants.AccountConstants;
import com.qa.constantsTests.Constants;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;
import com.qa.service.AccountService;
import com.qa.webservices.IConsumeAccNums;
import com.qa.webservices.IConsumePrizeGenerator;

public class ServiceTests {
	
	@InjectMocks
	private AccountService service;

	@Mock
	private IAccountRepo repo;
	
	@Mock
	private IConsumePrizeGenerator consumePrize;
	
	@Mock
	private IConsumeAccNums consumeAccount;
	
	@Mock
	private Account account;
	
	
	private Account MockAccount;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockAccount = new Account();
	}
	
	
	@Test
	public void testGetPrize() {
		Mockito.when(repo.findById(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Mockito.when(consumePrize.getPrize(MockAccount.getAccountNumber())).thenReturn(Constants.PRIZE_STRING);
		Assert.assertEquals(Constants.PRIZE_STRING, service.getPrize(MockAccount.getID()));
	}
	
	@Test
	public void testCreateAccount() {
		Mockito.when(consumeAccount.getAccountNumber(MockAccount)).thenReturn("123123");
		Mockito.when(repo.save(MockAccount)).thenReturn(MockAccount);
		Assert.assertEquals(MockAccount,service.createAccount(MockAccount));
	}
	
	@Test
	public void testDeleteAccount() {
		Mockito.when(repo.findById(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Assert.assertEquals(AccountConstants.DELETE_ACCOUNT,service.deleteAccount(MockAccount.getID()));
	}
	
	@Test
	public void testFindAccount() {
		Mockito.when(repo.findById(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Assert.assertEquals(Optional.ofNullable(MockAccount), service.findAccount(MockAccount.getID()));
		
	}
	
	@Test
	public void testGetAllAccounts() {
		List<Account> acclist = new ArrayList<Account>();
		acclist.add(MockAccount);
		Mockito.when(repo.findAll()).thenReturn(acclist);
		Assert.assertEquals(acclist, service.getAllAccounts());
	}
	 
	@Test
	public void testUpdateAccount() {
		Mockito.when(repo.findById(MockAccount.getID())).thenReturn(Optional.of(MockAccount));
		Assert.assertEquals(AccountConstants.ACCOUNT_UPDATED, service.updateAccount(MockAccount.getID(), MockAccount));
		
	}
	 


}
