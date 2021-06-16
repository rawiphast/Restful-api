package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String userNotFound (UserNotFoundException ex){
        return ex.getMessage();

    }
    
    @ResponseBody
    @ExceptionHandler(UserUnAuthenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userUnAuthen (UserUnAuthenException ex){
        return ex.getMessage();
}
}
