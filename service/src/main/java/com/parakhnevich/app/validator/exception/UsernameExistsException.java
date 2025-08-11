package com.parakhnevich.app.validator.exception;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException() {
        super("username.exists");
    }
}
