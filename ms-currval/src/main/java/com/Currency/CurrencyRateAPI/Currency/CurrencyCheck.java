package com.Currency.CurrencyRateAPI.Currency;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class CurrencyCheck {
    @Id
    @SequenceGenerator(
            name = "seq_currcheck",
            sequenceName = "seq_currcheck",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_currcheck"
    )
    private Long id;
    private String currency;
    private Date checkDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public CurrencyCheck() {

    }

    public CurrencyCheck(Long id,
                         String currency,
                         Date checkDate) {
        this.id = id;
        this.currency = currency;
        this.checkDate = checkDate;
    }

    public CurrencyCheck(String currency,
                         Date checkDate) {
        this.currency = currency;
        this.checkDate = checkDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CurrencyCheck{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", checkDate=" + checkDate +
                '}';
    }
}
