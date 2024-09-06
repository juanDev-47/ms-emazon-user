package com.emazon.user.domain.exception;

public class UnderageUserException extends RuntimeException{
    public UnderageUserException(String message) {
        super("Empty '" + message + "' field not allowed");
    }
}
