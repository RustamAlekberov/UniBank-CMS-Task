package com.Register.RegisterAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RegisterServiceTest {
    @Mock
    private RegisterRepository registerRepository;
    private RegisterService underTest;


    @BeforeEach
    void setUp() {
        underTest = new RegisterService(registerRepository);
    }


    @Test
    void canAddNewUser() {
        Users users = new Users(
                "Seygey Seygey",
                "7chh3zg",
                "123456"
        );

        underTest.addNewUser(users);

        ArgumentCaptor<Users> usersArgumentCaptor = ArgumentCaptor.forClass(Users.class);
        verify(registerRepository).save(usersArgumentCaptor.capture());
        Users capturedUsers = usersArgumentCaptor.getValue();
        assertThat(capturedUsers).isEqualTo(users);
    }
    @Test
    void willThrowWhenPinIsTaken() {
        Users users = new Users(
                "Seygey Seygey",
                "7chh3zg",
                "123456"
        );
        given(registerRepository.findUserByPin(users.getPin())).willReturn(Optional.of(users));

        assertThatThrownBy(() -> underTest.addNewUser(users))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Already registered pin");
        verify(registerRepository, never()).save(any());

    }
}