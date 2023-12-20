package com.accounts.AccountsAPI.WorkAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountsServiceTest {


    @Mock
    private AccountsRepository accRepository;

    @InjectMocks
    private AccountsService accService;

    Accounts account;
    Users user;

    List<Accounts> listAccounts;
    LoginCheck loginCheck;
    String pin;
    @BeforeEach
    void setUp() {
        account = new Accounts(
                "AZ46NABZ01350100000000015944",
                41010,
                new Date(),
                null,
                "Müxbir Hesab",
                "AZN",
                "Baş ofis",
                10000,
                10000d);

        pin="186prmh";

        user = new Users(
                "Ehmed Imanov",
                "186hrmh",
                "123456"
        );

    loginCheck = new LoginCheck();
    loginCheck.setPin("186hrmh");
    loginCheck.setToken("123456789");


    listAccounts = new ArrayList<>();
    listAccounts.add(account);
    }
    @Test
    void checkStatusIsSuccessWhileAddAccount() {

        when(accRepository.findUserByPin(pin)).thenReturn(Optional.of(user));

        accService.addAccounts(account,pin);

        ArgumentCaptor<Accounts> accArgumentCaptor = ArgumentCaptor.forClass(Accounts.class);
        verify(accRepository).save(accArgumentCaptor.capture());
        Accounts capturedAccount = accArgumentCaptor.getValue();
        assertThat(capturedAccount).isEqualTo(account);
    }

    @Test
    void givenTokenReturnListAccount() {
        when(accRepository.findLoginCheckByToken(loginCheck.getToken())).thenReturn(Optional.of(loginCheck));
        when(accRepository.findAccountsByDate(Optional.of(loginCheck).get().getPin())).thenReturn(Optional.of(listAccounts));

        Optional<List<Accounts>> respList=accService.showAccounts(loginCheck.getToken());
        assertThat(respList).isEqualTo(Optional.of(listAccounts));



    }
}