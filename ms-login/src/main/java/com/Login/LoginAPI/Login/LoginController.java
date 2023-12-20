package com.Login.LoginAPI.Login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "UniTech/LoginAPI/login")
public class LoginController {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<String> registerNewUser(@RequestBody Users users){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(users));
    }


}
