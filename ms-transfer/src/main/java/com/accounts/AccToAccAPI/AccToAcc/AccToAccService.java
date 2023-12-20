package com.accounts.AccToAccAPI.AccToAcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
public class AccToAccService {
    private final AccountsRepository accountsRepository;
    private final ArchPaymentsRepository archPaymentsRepository;

    @Autowired
    public AccToAccService(AccountsRepository accountsRepository, ArchPaymentsRepository archPaymentsRepository) {
        this.accountsRepository = accountsRepository;
        this.archPaymentsRepository = archPaymentsRepository;
    }

    @Transactional
    public String moneyTransfer(Double amount, String sendAccNumber, String getAccNumber) {
        Date today = new Date();
        Double resultGetBalance = 0d;
        Double resultSendBalance = 0d;

        Accounts getAccount = accountsRepository.findAccountsByAccNumber(getAccNumber);
        Accounts sendAccount = accountsRepository.findAccountsByAccNumber(sendAccNumber);

        if (getAccount == null) {
            throw new IllegalStateException("There is to make transfer to non existing account (Acceptor)");
        } else if (sendAccount == null) {
            throw new IllegalStateException("There is to make transfer to non existing account (Sender)");
        } else {
            if (amount > getAccount.getBalance()) {
                throw new IllegalStateException("There is no enough money in my account balance");
            } else if (getAccNumber.equals(sendAccNumber)) {
                throw new IllegalStateException("There is try to make transfer to same account");
            } else if (getAccount.getCloseDate() != null) {
                throw new IllegalStateException("There is try to make transfer to deactive account (Acceptor)");
            } else if (sendAccount.getCloseDate() != null) {
                throw new IllegalStateException("There is try to make transfer to deactive account (Sender)");
            } else {

                resultGetBalance = getAccount.getBalance() - amount;
                resultSendBalance = sendAccount.getBalance() + amount;

                ArchPayments archPayments = new ArchPayments();
                archPayments.setPaymentDate(today);
                archPayments.setFromAccId(getAccount);
                archPayments.setToAccId(sendAccount);
                archPayments.setAmount(amount);
                archPaymentsRepository.save(archPayments);

                getAccount.setBalance(resultGetBalance);

                sendAccount.setBalance(resultSendBalance);

                return "Success";
            }
        }
    }
}
