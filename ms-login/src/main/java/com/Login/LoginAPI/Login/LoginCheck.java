package com.Login.LoginAPI.Login;

import javax.persistence.*;

@Entity
@Table
public class LoginCheck {
    @Id
    @SequenceGenerator(
            name = "seq_logcheck",
            sequenceName = "seq_logcheck",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_logcheck"
    )
    private Long id;
    private String pin;
    private String token;

    public LoginCheck() {

    }

    public LoginCheck(Long id,
                      String pin,
                      String token) {
        this.id = id;
        this.pin = pin;
        this.token = token;

    }

    public LoginCheck(
            String pin,
            String token) {
        this.id = id;
        this.pin = pin;
        this.token = token;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginCheck{" +
                "id=" + id +
                ", pin='" + pin + '\'' +
                ", token=" + token +
                '}';
    }
}
