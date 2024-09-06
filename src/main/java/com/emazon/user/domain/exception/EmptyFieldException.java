package com.emazon.user.domain.exception;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException(String message) {
        super("Empty '" + message + "' field not allowed");
    }
}
