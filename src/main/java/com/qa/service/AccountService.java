package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.constants.AccountConstants;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;
import com.qa.webservices.IConsumeAccNums;
import com.qa.webservices.IConsumePrizeGenerator;

@Service
@Primary
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepo repo;
	
	@Autowired
	private IConsumeAccNums consumeAccount;
	
	@Autowired
	private IConsumePrizeGenerator consumePrize;
	
	
	@Override
	public String getPrize(Long id) {
		return consumePrize.getPrize(repo.findById(id).get().getAccountNumber());
	
	}
	
	@Override
	public Account createAccount(Account account) {
		account.setAccountNumber(consumeAccount.getAccountNumber(account));
		return repo.save(account);
	}

	@Override
	public String deleteAccount(Long id) {
		if (repo.findById(id) != null) {
			repo.deleteById(id);
			return AccountConstants.DELETE_ACCOUNT;
		}
		return AccountConstants.ACCOUNT_NOT_FOUND;
	}


	@Override
	public Optional<Account> findAccount(Long id) {
		return repo.findById(id);
	}

	@Override
	public Iterable<Account> getAllAccounts() {
		return repo.findAll();
	}

	@Override
	public String updateAccount(Long id, Account account) {
		if (repo.findById(id) != null) {
			Account oldAccount = repo.findById(id).get();
			oldAccount.setFirstName(account.getFirstName());
			oldAccount.setLastName(account.getLastName());
			oldAccount.setAccountNumber(account.getAccountNumber());
			return AccountConstants.ACCOUNT_UPDATED;
		}
		return AccountConstants.ACCOUNT_NOT_FOUND;
	}

}
