package com.Currency.CurrencyRateAPI.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @Mock
    private CurrencyCheckRepository currencyCheckRepository;
    @Mock
    private CurrencyRateRepository currencyRateRepository;

    @InjectMocks
    private CurrencyService currencyService;

    String val1;
    String val2;
    Long check;
    CurrencyRate currReturnValue1;
    CurrencyRate currReturnValue2;
    CurrencyCheck currencyCheck;

    Date maxDate;

    @BeforeEach
    void setUp() {
        val1 = "USD";
        val2 = "AZN";
        check = 0l;

        maxDate = new Date();

        currReturnValue1 = new CurrencyRate();
        currReturnValue1.setId(1l);
        currReturnValue1.setCbarCurr(1.340d);
        currReturnValue1.setCurrencyCode("EUR");
        currReturnValue1.setCurrencyName("Dollar");

        currReturnValue2 = new CurrencyRate();
        currReturnValue2.setId(2l);
        currReturnValue2.setCbarCurr(2d);
        currReturnValue2.setCurrencyCode("AZN");
        currReturnValue2.setCurrencyName("Manat");

        Users user = new Users();
        user.setFullname("RS-Root");
        user.setPin("10293847");


        currencyCheck = new CurrencyCheck();
        currencyCheck.setCurrency("USD");
        currencyCheck.setCheckDate(maxDate);
        currencyCheck.setUserId(user);
    }

    @Test
    void givenCurrencyRequestReturnsResult() throws ParserConfigurationException, IOException, SAXException {
        when(currencyRateRepository.findCurrCheck()).thenReturn(check);

        when(currencyRateRepository.findCurrencyValueBy1(anyString())).thenReturn(currReturnValue1);
        when(currencyRateRepository.findCurrencyValueBy2(anyString())).thenReturn(currReturnValue2);

        when(currencyCheckRepository.findLastDate(anyString())).thenReturn(maxDate);
        when(currencyCheckRepository.save(any(CurrencyCheck.class))).thenReturn(currencyCheck);

        Double result = currencyService.checkCurrency(val1, val2);

        assertThat(result).isEqualTo(currReturnValue1.getCbarCurr()/currReturnValue2.getCbarCurr());
    }

    @Test
    void updateCurrency() throws ParserConfigurationException, IOException, SAXException {
        when(currencyRateRepository.findCurrencyValueBy1(anyString())).thenReturn(currReturnValue2);
//        when(currencyRateRepository.save(any(CurrencyRate.class))).thenReturn(currReturnValue2);

        String result = currencyService.updateCurrency();

        assertThat(result).isEqualTo("Success");


    }
}