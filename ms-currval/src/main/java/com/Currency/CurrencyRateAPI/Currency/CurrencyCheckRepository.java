package com.Currency.CurrencyRateAPI.Currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CurrencyCheckRepository extends JpaRepository<CurrencyCheck, Long> {
    @Query("select max(t.checkDate) from CurrencyCheck t where t.currency =?1")
    Date findLastDate(String val1);
}
