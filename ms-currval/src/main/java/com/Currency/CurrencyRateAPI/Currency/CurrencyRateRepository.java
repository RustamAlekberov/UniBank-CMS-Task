package com.Currency.CurrencyRateAPI.Currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long>{

    @Query("select count(t.id) from CurrencyRate t ")
    Long findCurrCheck();
    @Query("select t from CurrencyRate t where t.currencyCode = ?1")
    CurrencyRate findCurrencyValueBy1(String val1);
    @Query("select t from CurrencyRate t where t.currencyCode = ?1")
    CurrencyRate findCurrencyValueBy2(String val2);

}
