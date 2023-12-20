package com.Login.LoginAPI.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Users, Long> {

    @Query("select t from Users t where t.pin = ?1 and t.password = ?2 ")
    Users findUser(String pin, String password);
}
