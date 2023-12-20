package com.accounts.AccToAccAPI.AccToAcc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    @Query("select t from Accounts t where t.accNumber = ?1")
    Accounts findAccountsByAccNumber(String number);


}