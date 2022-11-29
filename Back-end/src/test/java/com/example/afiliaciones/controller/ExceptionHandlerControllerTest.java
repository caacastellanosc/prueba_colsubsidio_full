package com.example.afiliaciones.controller;

import com.example.afiliaciones.util.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class ExceptionHandlerControllerTest {

    @Autowired
    private ExceptionHandlerController exceptionHandlerController;

    @Test
    void testException() {
        Response<Object> response = exceptionHandlerController.exception(new Exception("Exception Test"), mock(HttpServletRequest.class));
        Assertions.assertEquals(500,response.getCode());
    }

}