package com.Login.LoginAPI.Login;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name = "seq_users",
            sequenceName = "seq_users",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_users"
    )
    private Long id;
    private String fullname;
    private String pin;
    private String password;

    public Users() {

    }

    public Users(Long id,
                 String fullname,
                 String pin,
                 String password) {
        this.id = id;
        this.fullname = fullname;
        this.pin = pin;
        this.password = password;
    }

    public Users(
            String fullname,
            String pin,
            String password) {
        this.id = id;
        this.fullname = fullname;
        this.pin = pin;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", pin=" + pin +
                ", password='" + password + '\'' +
                '}';
    }
}

