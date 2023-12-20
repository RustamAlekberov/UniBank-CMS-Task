package com.Register.RegisterAPI;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RegisterRepositoryTest {

    @Autowired
    private RegisterRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenFindUserByPinIsExisting() {
        String pin = "7chh3zg";
        Users users = new Users(
                "Seygey Seygey",
                pin,
                "123456"
        );
        underTest.save(users);

        Optional<Users> exists = underTest.findUserByPin(pin);

        assertThat(exists).isPresent();
    }
    @Test
    void itShouldCheckWhenFindUserByPinIsNotExisting() {

        String pin = "7chh3zg";

        Optional<Users> exists = underTest.findUserByPin(pin);

        assertThat(exists).isNotPresent();
    }
}