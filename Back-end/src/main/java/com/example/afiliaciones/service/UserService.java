package com.example.afiliaciones.service;

import com.example.afiliaciones.dto.DateTimeDto;
import com.example.afiliaciones.dto.ResponseParamDto;
import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;

import java.util.List;

public interface UserService {

    User registerUser(UserDto user);

    User getUserByEmail(String Email);

    List<User> getUserByDateCreate(DateTimeDto dateTimeDto);

    List<User> getUserByDateModify(DateTimeDto dateTimeDto);

    List<User> getUserByDateLastLogin(DateTimeDto dateTimeDto);

    List<User> getUserByActive(String active);

    List<User> getUserByContryCode(String code);

    List<User> getUserByCityCode(String code);

    List<User> getUserAll();

    List<User> getUserByName(String name);

    List<User> getUserByThreeParam(ResponseParamDto responseParamDto);


}
