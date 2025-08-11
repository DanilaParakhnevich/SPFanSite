package com.parakhnevich.app.validator.exception;

public class BadUsernameException extends RuntimeException {

    public BadUsernameException() {
        super("bad.username");
    }

}
