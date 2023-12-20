package com.register.registerapi.service;

import com.register.registerapi.dto.UserDTO;
import com.register.registerapi.entity.UserEntity;
import com.register.registerapi.mapper.UserMapper;
import com.register.registerapi.repositroy.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    private final UserMapper userMapper;


    public void addNewUser(UserDTO userDTO){
        System.out.println(userDTO);
        UserEntity userEntity = userMapper.userDtoToUser(userDTO);
        System.out.println(userEntity);
        System.out.println(userEntity.getPin());
        Optional<UserEntity> usersOptional = registerRepository.findUserByPin(userEntity.getPin());
        System.out.println(usersOptional);
        if (usersOptional.isPresent()){
            throw new IllegalStateException("Already registered pin");
        }
        registerRepository.save(userEntity);
    }
}
