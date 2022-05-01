package dev.georgev.stms.controller;

import dev.georgev.stms.exception.ResourceNotFoundException;
import dev.georgev.stms.model.Account;
import dev.georgev.stms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // find account by ID
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));
        return ResponseEntity.ok(account);
    }

    // create account
    @PostMapping("/account")
    public Account createAccount(@RequestBody Account a) {
        return accountRepository.save(a);
    }

    // Update account
    @PutMapping("/account/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account acc = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));
        acc.setFirst_name(account.getFirst_name());
        acc.setLast_name(account.getLast_name());
        acc.setEmail(account.getEmail());

        Account updAcc = accountRepository.save(acc);
        return ResponseEntity.ok(updAcc);
    }

    // Remove account
    @DeleteMapping("/account/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));

        accountRepository.delete(account);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(res);
    }
}
