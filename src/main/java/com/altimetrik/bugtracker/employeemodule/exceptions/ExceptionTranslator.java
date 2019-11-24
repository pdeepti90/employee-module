package com.altimetrik.bugtracker.employeemodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
//@Re
public class ExceptionTranslator extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBadRequestAlertException (BadRequestAlertException exception, WebRequest request){
       //ToDO: The exception response can be done with a builder design pattern. Have a look at it
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),"",LocalDateTime.now());
return  new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
