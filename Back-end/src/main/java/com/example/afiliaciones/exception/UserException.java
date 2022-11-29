package com.example.afiliaciones.exception;

/**
 * Clase encargada de lanzar una excepción cuando hay un error en Usuario
 */
public class UserException extends RuntimeException{

    /**
     * Método encargado de inicializar variables
     *
     * @param message, Mensaje de la excepción del error ha lanzar
     */
    public UserException(String message)
    {
        super(message);
    }
}
