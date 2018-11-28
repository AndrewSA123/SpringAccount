package com.qa.rest;

import java.util.Optional;

import com.qa.persistence.domain.Account;

public interface IAccountEndpoint {

	public Iterable<Account> getAllAccounts();

	public Optional<Account> findAccount(Long id);

	public Account createAccount(Account account);

	public String deleteAccount(Long id);

	public String updateAccount(Long id, Account account);

	public String getPrize(String accountNumber);

}
