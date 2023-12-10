package com.application.lms.exception;

public class NameAlreadyTakenException extends RuntimeException {
    public NameAlreadyTakenException(String message) {
        super(message);
    }
}
