package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Account;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {


}
