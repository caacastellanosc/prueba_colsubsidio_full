package com.example.afiliaciones.controller;

import com.example.afiliaciones.exception.UserException;
import com.example.afiliaciones.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * Controlador Rest para las excepciones
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * Mensaje de error genérico.
     */
    private static final String GENERIC_ERROR_MESSAGE = "Ha ocurrido un error, inténtalo de nuevo más tarde";

    /**
     * Método encargado de capturar las excepciones generales
     *
     * @param e       Solicitud con la clase Exception
     * @param request Solicitud con acceso a los datos de cabecera HTTP
     * @return Respuesta con la información explicita del error
     */
    @ExceptionHandler(Exception.class)
    public Response<Object> exception(Exception e, HttpServletRequest request) {

        log.info("Exception: Url Request: {} | Message: {}", request.getContextPath(), e.getMessage());

        return Response.builder()
                .failure(true)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage()==null?GENERIC_ERROR_MESSAGE:e.getMessage())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    /**
     * Método encargado de capturar las excepciones del usuario
     * @param e Solicitud de excepción CipherException
     * @param request Solicitud con acceso a los datos de cabecera HTTP
     * @return Respuesta con los datos de información del error del cifrado
     */
    @ExceptionHandler({UserException.class})
    public Response<Object> userException(Exception e, HttpServletRequest request) {

        log.error("userException: Url Request: {} | Message: {} ", request.getRequestURI(), e.getMessage());

        return Response.builder()
                .failure(true)
                .code(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();

    }
}