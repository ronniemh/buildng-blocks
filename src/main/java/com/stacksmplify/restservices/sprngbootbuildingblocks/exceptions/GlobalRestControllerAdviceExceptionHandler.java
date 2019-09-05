package com.stacksmplify.restservices.sprngbootbuildingblocks.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * GlobalRestControllerAdviceExceptionHandler
 */
//@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails usernameNotFound(UserNameNotFoundException ex){
        return new CustomErrorDetails(new Date(), "From @RestControllerAdvice", ex.getMessage());
    }
    
}