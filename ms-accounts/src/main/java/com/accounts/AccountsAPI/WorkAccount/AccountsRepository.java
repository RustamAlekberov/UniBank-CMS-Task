package com.accounts.AccountsAPI.WorkAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    @Query("select t from Users t where t.pin = ?1")
    Optional<Users> findUserByPin(String pin);

    @Query("select t from LoginCheck t where t.token = ?1")
    Optional<LoginCheck> findLoginCheckByToken(String token);

    @Query("select t from Accounts t where t.userId.pin =?1 and t.closeDate is not null")
    Optional<List<Accounts>> findAccountsByDate(String pin);

}
