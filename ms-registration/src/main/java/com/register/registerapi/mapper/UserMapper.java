package com.register.registerapi.mapper;
import com.register.registerapi.dto.UserDTO;
import com.register.registerapi.entity.UserEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDto(UserEntity userEntity);
    UserEntity userDtoToUser(UserDTO userDTO);
}
