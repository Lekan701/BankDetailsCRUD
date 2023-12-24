package com.example.demo.service;

import com.example.demo.entity.Account;
import java.util.List;


public interface BankAccountService {

    // Save Operation
    Account saveAccount(Account account);

    // Read Operation
    List<Account> fetchAccountList();

    // Update Operation
    Account updateAccount(Account account, Long accountId);

    // Delete Operation
    void deleteAccountById(Long accountId);
}
