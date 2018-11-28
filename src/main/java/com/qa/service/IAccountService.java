package com.qa.service;

import java.util.Optional;

import com.qa.persistence.domain.Account;

public interface IAccountService {

	public Account createAccount(Account account);

	public String deleteAccount(Long id);

	public Optional<Account> findAccount(Long id);

	public Iterable<Account> getAllAccounts();

	public String updateAccount(Long id, Account account);

	String getPrize(Long id);

}
