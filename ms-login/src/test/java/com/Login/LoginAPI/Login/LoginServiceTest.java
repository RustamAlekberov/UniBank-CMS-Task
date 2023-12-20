package com.Login.LoginAPI.Login;

import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private LoginRepository loginRepository;
    @Mock
    private LoginCheckRepository loginCheckRepository;
    @InjectMocks
    private LoginService underTest;

    Users users;
    @BeforeEach
    void setUp() {
         users = new Users(
                "Ehmed Imanov",
                "186hrmh",
                "123456"
        );
        underTest = new LoginService(loginRepository, loginCheckRepository);
    }

    @Test
    void canLogin() {
        when(loginRepository.findUser(users.getPin(), users.getPassword())).thenReturn(users);

//        when(underTest.login(users)).thenReturn("123456789");
        underTest.login(users);

//        ArgumentCaptor<Users> usersArgumentCaptor = ArgumentCaptor.forClass(Users.class);
//        verify(loginRepository).save(usersArgumentCaptor.capture());
//        Users capturedUsers = usersArgumentCaptor.getValue();

        assertThat(users).isNotNull();
    }
}