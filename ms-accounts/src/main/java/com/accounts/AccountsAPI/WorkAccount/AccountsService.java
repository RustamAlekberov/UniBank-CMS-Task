package com.accounts.AccountsAPI.WorkAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountsService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public String addAccounts(Accounts account, String pin) {
        Optional<Users> usersOptional = accountsRepository.findUserByPin(pin);
        if (usersOptional.isPresent()) {
            account.setUserId(usersOptional.get());
            accountsRepository.save(account);
            return "Success";
        } else {
            throw new IllegalStateException("Your user PIN is incorrect");
        }
    }

    public Optional<List<Accounts>> showAccounts(String token) {
        Optional<LoginCheck> loginCheckOptional = accountsRepository.findLoginCheckByToken(token);
        if (loginCheckOptional.isEmpty()) {
            throw new IllegalStateException("Your user Token is incorrect");
        }
        Optional<List<Accounts>> accountsList = accountsRepository.findAccountsByDate(loginCheckOptional.get().getPin());
        return accountsList;
    }
}