package com.emazon.user.domain.exception;

public class TokenNullException extends RuntimeException {
    public TokenNullException(String message){
        super(message);
    }
}
