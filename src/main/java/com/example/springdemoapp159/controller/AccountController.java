package com.example.springdemoapp159.controller;

import com.example.springdemoapp159.model.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/{accountNumber}")
    public static AccountDto getAllAccounts(@PathVariable String accountNumber) {
        var account = allAccount();
        return account.stream().filter((c-> c.getNumber().equals(accountNumber))).findFirst().orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAccount(@RequestBody AccountDto account) {
        var addAccount = allAccount();
        addAccount.add(account);
        System.out.println("Account added: " + addAccount);
    }
    @PutMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@RequestBody AccountDto account, @PathVariable String accountNumber) {
        var updateAccount = allAccount();
        var updateAccountInformation = updateAccount.stream().filter((c) -> c.getNumber().equals(accountNumber)).findFirst().orElse(null);
        System.out.println("before update:"+updateAccountInformation);
        updateAccountInformation.setBalance(account.getBalance());
        updateAccountInformation.setNumber(account.getNumber());

    }

    private static List<AccountDto> allAccount(){
        AccountDto accountDto = new AccountDto("1234-5678",100.0);
        AccountDto accountDto1 = new AccountDto("4169-7388",200.0);
        AccountDto accountDto2 = new AccountDto("4098-5844",300.0);
        List<AccountDto> accountDtos = new ArrayList<>();
        accountDtos.add(accountDto);
        accountDtos.add(accountDto1);
        accountDtos.add(accountDto2);
        return accountDtos;
    }

}
