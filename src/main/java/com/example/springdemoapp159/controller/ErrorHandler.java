package com.example.springdemoapp159.controller;

import com.example.springdemoapp159.exception.ValidationException;
import com.example.springdemoapp159.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFoundException(ValidationException e){
        return new ExceptionDto(e.getMessage());
    }
}
