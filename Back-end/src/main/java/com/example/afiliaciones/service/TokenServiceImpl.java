package com.example.afiliaciones.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Clase que implementa los metodos definidos en la interface TokenService
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Value("${token.secret}")
    private String secretToken;

    @Value("${token.expire}")
    private String expire;
    
    @Value("${token.issuer}")
    private String issuer;

    

    /**
     * @see TokenService#createToken()
     * 
     */
    @Override
    public String createToken() {
        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withNotBefore(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + Long.valueOf(expire)))
                .sign(Algorithm.HMAC256(secretToken));
    }

    /**
     * @see TokenService#checkToken(String) 
     *
     */
    @Override
    public Boolean checkToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secretToken))
                    .withIssuer(issuer).build()
                    .verify(token);
            return true;

        } catch (JWTVerificationException ex) {
            return false;
        }
    }
}
