package com.example.afiliaciones.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ActiveProfiles("test")
class TokenServiceTest {

    @Autowired
    private TokenService tokenServiceImpl;

    @Test
     void shouldCreateTokenAuthorization() {
        assertNotNull(tokenServiceImpl.createToken());
    }

    @Test
     void shouldVerifyCheckToken() {
        assertNotNull(tokenServiceImpl.checkToken(tokenServiceImpl.createToken()));
    }

}