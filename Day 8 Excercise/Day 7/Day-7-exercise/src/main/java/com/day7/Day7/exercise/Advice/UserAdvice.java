package com.day7.Day7.exercise.Advice;

import com.day7.Day7.exercise.Exceptions.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException (ApiException e){
        String message =e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

}


