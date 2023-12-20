package com.Login.LoginAPI.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoginService {
    private final LoginRepository loginRepository;
    private final LoginCheckRepository loginCheckRepository;
    private LoginCheck loginCheck;

    @Autowired
    public LoginService(LoginRepository loginRepository, LoginCheckRepository loginCheckRepository) {
        this.loginRepository = loginRepository;
        this.loginCheckRepository = loginCheckRepository;
    }

    public LoginCheck getLoginCheck() {
        return loginCheck;
    }

    public void setLoginCheck(LoginCheck loginCheck) {
        this.loginCheck = loginCheck;
    }

    public String login(Users usr) {
        UUID randomUUID = UUID.randomUUID();
        String randomStr = randomUUID.toString().replaceAll("_", "");
        Users users = loginRepository.findUser(usr.getPin(), usr.getPassword());
        if (users != null) {
            if (loginCheck == null) {
                loginCheck = new LoginCheck();
            }
            loginCheck.setPin(users.getPin());
            loginCheck.setToken(randomStr);
            loginCheckRepository.save(loginCheck);
            return randomStr;
        } else {
            throw new IllegalStateException("Login Failed: Your user PIN or password is incorrect");

        }
    }
}
