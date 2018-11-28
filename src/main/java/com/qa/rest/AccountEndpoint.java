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

@RequestMapping("${base_endpoint}")
@RestController
public class AccountEndpoint implements IAccountEndpoint {

	@Autowired
	private IAccountService service;

	@Autowired
	private IConsumePrizeGenerator prizeGen;

	@Override
	@GetMapping("${getall_endpoint}")
	public Iterable<Account> getAllAccounts() {
		return service.getAllAccounts();
	}

	@Override
	@GetMapping("${find_endpoint}")
	public Optional<Account> findAccount(@PathVariable Long id) {
		return service.findAccount(id);
	}

	@Override
	@PostMapping("${create_endpoint}")
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}


	@Override
	@DeleteMapping("${delete_endpoint}")
	public String deleteAccount(@PathVariable Long id) {
		return service.deleteAccount(id);
	}

	@Override
	@PutMapping("${update_endpoint}")
	public String updateAccount(@PathVariable Long id, @RequestBody Account account) {
		return service.updateAccount(id, account);
	}

	@Override
	@GetMapping("${getprize_endpoint}")
	public String getPrize(@PathVariable("id") String accountNumber) {
		return prizeGen.getPrize(accountNumber);
	}

}
