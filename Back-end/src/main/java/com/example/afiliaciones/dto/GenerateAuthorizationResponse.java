package com.example.afiliaciones.dto;

import lombok.*;

/**
 * Clase encargada de transmitir el token de autorización
 */
@Getter
@Setter
@NoArgsConstructor
public class GenerateAuthorizationResponse {

     private String token;
}
