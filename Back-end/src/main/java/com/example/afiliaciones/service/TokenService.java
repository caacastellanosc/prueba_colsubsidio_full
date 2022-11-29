package com.example.afiliaciones.service;

public interface TokenService {

    String createToken();

    Boolean checkToken(String token);
}
