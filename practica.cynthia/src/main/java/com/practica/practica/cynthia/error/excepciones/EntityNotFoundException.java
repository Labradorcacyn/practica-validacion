package com.practica.practica.cynthia.error.excepciones;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
