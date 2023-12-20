package com.Login.LoginAPI.Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoginRepositoryTest {

    @Autowired
    private LoginRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenFindUserByPinAndPasswordIsExisting() {
        String pin = "7chh3zg";
        String pass = "123456";
        Users users = new Users(
                "Seygey Seygey",
                pin,
                pass
        );
        underTest.save(users);

        Users exists = underTest.findUser(pin,pass);

        assertThat(exists).isEqualTo(users);
    }

    @Test
    void itShouldCheckWhenFindUserByPinAndPasswordIsNotExisting() {
        String pin = "7chh3zg";
        String pass = "123456";

        Users exists = underTest.findUser(pin,pass);

        assertThat(exists).isNull();
    }

}