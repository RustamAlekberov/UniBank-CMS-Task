package com.register.registerapi.controller;

import com.register.registerapi.dto.UserDTO;
import com.register.registerapi.service.RegisterService;
import com.register.registerapi.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "UniTech/RegisterApi/registration")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public void registerNewUser(@RequestBody UserDTO userDTO){
        registerService.addNewUser(userDTO);
    }
}