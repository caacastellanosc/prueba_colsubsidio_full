package com.example.afiliaciones.controller;

import com.example.afiliaciones.dto.DateTimeDto;
import com.example.afiliaciones.dto.ResponseParamDto;
import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;
import com.example.afiliaciones.service.UserService;
import com.example.afiliaciones.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registro")
        public Response<User> saveUser(@Valid @RequestBody UserDto user) {

        return Response.<User>builder()
                .body(userService.registerUser(user))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/correo/{email}")
    public Response<User> getUserByEmail(@PathVariable(name = "email")String email) {

        return Response.<User>builder()
                .body(userService.getUserByEmail(email))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/creado")
    public Response<List<User>> getUserByDateCreate(@Valid @RequestBody DateTimeDto dateTimeDto) {

        return Response.<List<User>>builder()
                .body(userService.getUserByDateCreate(dateTimeDto))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/modificado")
    public Response<List<User>> getUserByDateModify(@Valid @RequestBody DateTimeDto dateTimeDto) {

        return Response.<List<User>>builder()
                .body(userService.getUserByDateModify(dateTimeDto))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/ultima")
    public Response<List<User>> getUserByDateLastLogin(@Valid @RequestBody DateTimeDto dateTimeDto) {

        return Response.<List<User>>builder()
                .body(userService.getUserByDateLastLogin(dateTimeDto))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/activo/{active}")
    public Response<List<User>> getUserByActive(@PathVariable(name = "active") String active) {

        return Response.<List<User>>builder()
                .body(userService.getUserByActive(active))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/pais/{code}")
    public Response<List<User>> getUserByContryCode(@PathVariable(name = "code") String code) {

        return Response.<List<User>>builder()
                .body(userService.getUserByContryCode(code))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/ciudad/{code}")
    public Response<List<User>> getUserByCityCode(@PathVariable(name = "code") String code) {

        return Response.<List<User>>builder()
                .body(userService.getUserByCityCode(code))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/todos")
    public Response<List<User>> getUserAll() {
        return Response.<List<User>>builder()
                .body(userService.getUserAll())
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/nombre/{name}")
    public Response<List<User>> getUserName(@PathVariable(name = "name") String name) {
        return Response.<List<User>>builder()
                .body(userService.getUserByName(name))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/parametros")
    public Response<List<User>> getUserByThreeParam(@RequestBody ResponseParamDto responseParamDto) {
        return Response.<List<User>>builder()
                .body(userService.getUserByThreeParam(responseParamDto))
                .code(HttpStatus.OK.value())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }
}
