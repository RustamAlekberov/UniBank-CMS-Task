package com.accounts.AccountsAPI.WorkAccount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountsRepositoryTest {

    @Autowired
    private AccountsRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }


    @Test
    void findUserByPin() {
    }

    @Test
    void findLoginCheckByToken() {
    }

    @Test
    void findAccountsByDate() {
    }
}