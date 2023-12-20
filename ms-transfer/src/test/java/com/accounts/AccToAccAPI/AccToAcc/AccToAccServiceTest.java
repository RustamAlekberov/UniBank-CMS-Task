package com.accounts.AccToAccAPI.AccToAcc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccToAccServiceTest {


    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private ArchPaymentsRepository archPaymentsRepository;

    @InjectMocks
    private AccToAccService accToAccService;

    @BeforeEach
    void setUp() {

        IBAN1 = "AZ46NABZ01350100000000015944";
        IBAN2 = "AZ46NABZ01350100000000015001";
        fromAcc = new Accounts(
                "AZ46NABZ01350100000000015944",
                41010,
                new Date(),
                null,
                "Müxbir Hesab",
                "AZN",
                "Baş ofis",
                10000,
                10000d);
        toAcc = new Accounts(
                "AZ46NABZ01350100000000015001",
                41010,
                new Date(),
                null,
                "Ikinci Hesab",
                "AZN",
                "Baş ofis",
                10000,
                3000d);


        archPayment = new ArchPayments();
        archPayment.setPaymentDate(new Date());
        archPayment.setAmount(100d);
        archPayment.setFromAccId(fromAcc);
        archPayment.setToAccId(toAcc);
    }

    ArchPayments archPayment;
    Accounts fromAcc;
    Accounts toAcc;
    String IBAN1;
    String IBAN2;


    @Test
    void moneyTransferBetweenTwoIBAN() {
        when(accountsRepository.findAccountsByAccNumber(IBAN1)).thenReturn(fromAcc);
        when(accountsRepository.findAccountsByAccNumber(IBAN2)).thenReturn(toAcc);
        when(archPaymentsRepository.save(any(ArchPayments.class))).thenReturn(archPayment);

        String resp = accToAccService.moneyTransfer(100d, IBAN1, IBAN2);

        assertThat(resp).isEqualTo("Success");

    }
}