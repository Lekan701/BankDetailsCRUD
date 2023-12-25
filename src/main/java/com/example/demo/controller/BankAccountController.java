package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.BankAccountService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankAccountController {

    @Autowired private BankAccountService bankAccountService;

    // Save Operation
    @PostMapping("/accounts")
    public Account saveAccount(
            @Valid @RequestBody Account account)
    {
        return bankAccountService.saveAccount(account);
    }

    // Read Operation
    @GetMapping("/accounts")
    public List<Account> fetchAccountList()
    {
        return bankAccountService.fetchAccountList();
    }

    // Update Operation
    @PutMapping("/accounts/{id}")
    public Account
    updateAccount(@RequestBody Account account,
                  @PathVariable("id") Long accountId)
    {
        return bankAccountService.updateAccount(
                account, accountId);
    }

    // Delete Operation
    @DeleteMapping("/accounts/{id}")
    public String deleteAccountById(@PathVariable("id")
                                    Long accountId)
    {
        bankAccountService.deleteAccountById(
                accountId);
        return "Deleted Successfully";
    }
}
