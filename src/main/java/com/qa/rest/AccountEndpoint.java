package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Account;
import com.qa.service.IAccountService;
import com.qa.webservices.IConsumePrizeGenerator;

@RequestMapping("/account")
@RestController
public class AccountEndpoint implements IAccountEndpoint {

	@Autowired
	private IAccountService service;

	@Autowired
	private IConsumePrizeGenerator prizeGen;

	@Override
	@GetMapping("/getall")
	public Iterable<Account> getAllAccounts() {
		return service.getAllAccounts();
	}

	@Override
	@GetMapping("/find/{id}")
	public Optional<Account> findAccount(@PathVariable Long id) {
		return service.findAccount(id);
	}

	@Override
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}


	@Override
	@DeleteMapping("/delete/{id}")
	public String deleteAccount(@PathVariable Long id) {
		return service.deleteAccount(id);
	}

	@Override
	@PutMapping("/update/{id}")
	public String updateAccount(@PathVariable Long id, @RequestBody Account account) {
		return service.updateAccount(id, account);
	}

	@Override
	@GetMapping("/getprize/{id}")
	public String getPrize(@PathVariable("id") String accountNumber) {
		return prizeGen.getPrize(accountNumber);
	}

}
