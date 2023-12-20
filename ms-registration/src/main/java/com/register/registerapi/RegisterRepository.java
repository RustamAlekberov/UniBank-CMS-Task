package com.Register.RegisterAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Users, Long> {

    @Query("select t from Users t where t.pin = ?1")
    Optional<Users> findUserByPin(String pin);
}
