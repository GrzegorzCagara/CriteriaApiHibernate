package com.moler.task.exception;

public class BadQueryParametersException extends RuntimeException {
    public BadQueryParametersException(String message) {
        super(message);
    }
}
