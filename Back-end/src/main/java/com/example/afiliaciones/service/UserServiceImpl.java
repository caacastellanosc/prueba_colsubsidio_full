package com.example.afiliaciones.service;

import com.example.afiliaciones.dto.DateTimeDto;
import com.example.afiliaciones.dto.ResponseParamDto;
import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;
import com.example.afiliaciones.exception.UserException;
import com.example.afiliaciones.mapper.UserMapper;
import com.example.afiliaciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    /**
     * tokenService
     */
    private final TokenService tokenService;

    /**
     * Constructor de UserServiceImpl
     *
     * @param tokenService
     */
    public UserServiceImpl(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User registerUser(UserDto user) {

        if(Objects.nonNull(userRepository.findByEmail(user.getEmail()))){
            throw new UserException("El correo ya está registrado");
        }

        User newUser= userMapper.userDtouser(user);
        newUser.setId(UUID.randomUUID().toString());
        newUser.setCreated(new Date());
        newUser.setModified(new Date());
        newUser.setLastLogin(new Date());
        newUser.setToken(tokenService.createToken());
        newUser.setIsActive(true);
        return userRepository.save(newUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUserByDateCreate(DateTimeDto dateTimeDto) {
        return  userRepository.findByDateCreate(dateTimeDto.getStartDate(),dateTimeDto.getEndDate());
    }

    @Override
    public List<User> getUserByDateModify(DateTimeDto dateTimeDto) {
        return  userRepository.findByDateModify(dateTimeDto.getStartDate(),dateTimeDto.getEndDate());
    }

    @Override
    public List<User> getUserByDateLastLogin(DateTimeDto dateTimeDto) {
        return userRepository.findByDateLastLogin(dateTimeDto.getStartDate(),dateTimeDto.getEndDate());
    }

    @Override
    public List<User> getUserByActive(String active) {
        return userRepository.findByActive(active);
    }

    @Override
    public List<User> getUserByContryCode(String code) {
        return userRepository.findByContryCode(code);
    }

    @Override
    public List<User> getUserByCityCode(String code) {
        return userRepository.findByCityCode(code);
    }

    @Override
    public List<User> getUserAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getUserByThreeParam(ResponseParamDto responseParamDto){
        if(responseParamDto.getStartDate().equals("") || responseParamDto.getEndDate().equals("")){
            responseParamDto.setStartDate("2000-01-01");

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            responseParamDto.setEndDate(date.concat(" 23:59:59.000"));
        }
        return userRepository.findByThreeParam(responseParamDto.getName(),responseParamDto.getEmail(),responseParamDto.getStartDate(),responseParamDto.getEndDate());
    }

}
