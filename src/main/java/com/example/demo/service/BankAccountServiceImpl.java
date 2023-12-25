package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repository.BankAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountsRepository bankAccountsRepository;

    @Override
    public Account saveAccount(Account account) {
        return bankAccountsRepository.save(account);
    }

    @Override
    public List<Account> fetchAccountList() {
        return (List<Account>) bankAccountsRepository.findAll();
    }

    @Override
    public Account updateAccount(Account account, Long accountId) {
        Account accDB
                = bankAccountsRepository.findById(accountId)
                .get();

        if (Objects.nonNull(account.getAccountName())
                && !"".equalsIgnoreCase(
                account.getAccountName())){
            accDB.setAccountName(
                    account.getAccountName());
        }

        if (Objects.nonNull(account.getAccountNumber())
                && !"".equalsIgnoreCase(
                account.getAccountNumber())){
            accDB.setAccountNumber(
                    account.getAccountNumber());
        }

        if (Objects.nonNull(account.getAccountSortCode())
                && !"".equalsIgnoreCase(
                account.getAccountSortCode())){
            accDB.setAccountSortCode(
                    account.getAccountSortCode());
        }

        if (Objects.nonNull(account.getAccountBalance())
                && !"".equalsIgnoreCase(
                String.valueOf(account.getAccountBalance()))){
            accDB.setAccountBalance(
                    account.getAccountBalance());
        }

        return bankAccountsRepository.save(accDB);
    }

    @Override
    public void deleteAccountById(Long accountId) {
        bankAccountsRepository.deleteById(accountId);
    }
}
