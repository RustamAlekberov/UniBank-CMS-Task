package com.accounts.AccToAccAPI.AccToAcc;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ArchPayments {
    @Id
    @SequenceGenerator(
            name = "seq_arch_payment",
            sequenceName = "seq_arch_payment",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_arch_payment"
    )

    private Long id;
    private Date paymentDate;
    private Double amount;
    @JoinColumn(name = "FROM_ACC_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts fromAccId;

    @JoinColumn(name = "TO_ACC_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts toAccId;

    public ArchPayments() {

    }

    public ArchPayments(Long id,
                        Date paymentDate,
                        Double credit,
                        Double debit) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public ArchPayments(
            Date paymentDate,
            Double credit,
            Double debit) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Accounts getFromAccId() {
        return fromAccId;
    }

    public void setFromAccId(Accounts fromAccId) {
        this.fromAccId = fromAccId;
    }

    public Accounts getToAccId() {
        return toAccId;
    }

    public void setToAccId(Accounts toAccId) {
        this.toAccId = toAccId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
