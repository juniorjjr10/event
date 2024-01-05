package com.example.eventsmicroservice.exception;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(){
        super("evento não encontrado");


    }
    public EventNotFoundException(String message){
        super(message);
    }
}
