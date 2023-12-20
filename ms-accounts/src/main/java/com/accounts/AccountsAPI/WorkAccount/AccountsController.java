package com.accounts.AccountsAPI.WorkAccount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "UniTech/AccountsAPI/getAcc")
public class AccountsController {

    private final AccountsService accountsService;

    @Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping(value = "/addacc/{pin}")
    public ResponseEntity<String> registerNewAccount(@RequestBody Accounts accounts, @PathVariable String pin) {
        return ResponseEntity.status(HttpStatus.OK).body(accountsService.addAccounts(accounts, pin));
    }

    @GetMapping(value = "/showacc/{token}")
    public ResponseEntity<Optional<List<Accounts>>> getAccounts(@PathVariable String token) {
        return ResponseEntity.status(HttpStatus.OK).body(accountsService.showAccounts(token));
    }

}
