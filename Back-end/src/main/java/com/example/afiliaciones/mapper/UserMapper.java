package com.example.afiliaciones.mapper;

import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

	User userDtouser(UserDto user);
}
