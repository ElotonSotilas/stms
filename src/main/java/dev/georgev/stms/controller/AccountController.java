package dev.georgev.stms.controller;

import dev.georgev.stms.model.Account;
import dev.georgev.stms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    // get all accounts
    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // create account REST API
    @PostMapping("/account")
    public Account createAccount(@RequestBody Account a) {
        return accountRepository.save(a);
    }

    // Remove account REST API
    @DeleteMapping("/account")
    public boolean removeAccount(@RequestBody Account a) {
        return accountRepository.findAll().remove(a);
    }
}
