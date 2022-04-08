package com.aeviles.myapi.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    //Construtor que recebe a mensagem de erro e causa
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    //Construtor que recebe a mensagem
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
