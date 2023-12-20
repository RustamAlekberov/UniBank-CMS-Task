package com.Register.RegisterAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RegisterService {
    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public void addNewUser(Users user){
        Optional<Users> usersOptional = registerRepository.findUserByPin(user.getPin());
        if (usersOptional.isPresent()){
            throw new IllegalStateException("Already registered pin");
        }
        registerRepository.save(user);
    }
}
