package com.parakhnevich.app.validator.exception;

public class BadPasswordException extends RuntimeException {

    public BadPasswordException() {
        super("bad.password");
    }

}
