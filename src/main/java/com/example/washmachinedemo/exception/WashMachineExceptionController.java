package com.example.washmachinedemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WashMachineExceptionController
{
    @ExceptionHandler({ InvalidTimeException.class })
    public void customException(final InvalidTimeException ex) {
        System.out.println(ex.getMessage());
    }
}
