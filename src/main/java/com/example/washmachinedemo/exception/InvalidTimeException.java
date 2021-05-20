package com.example.washmachinedemo.exception;

public class InvalidTimeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public InvalidTimeException(final String message) {
        super(message);
    }
}
