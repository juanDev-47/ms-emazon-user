package com.emazon.user.domain.exception;

public class BadPasswordException extends RuntimeException{
    public BadPasswordException(String message) {
        super(message);
    }
}
