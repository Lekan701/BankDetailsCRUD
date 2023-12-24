package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending CrudRepository
public interface BankAccountsRepository extends CrudRepository<Account, Long>{
}
