package com.example.eventsmicroservice.exception;

public class EventFullException extends RuntimeException {
    public EventFullException() {
        super("Evento está lotado");

    }
    public EventFullException(String masage){
        super(masage);
    }


}
