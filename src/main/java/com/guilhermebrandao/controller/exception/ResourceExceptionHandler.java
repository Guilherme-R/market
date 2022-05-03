package com.guilhermebrandao.controller.exception;

import com.guilhermebrandao.service.exception.InvalidPassword;
import com.guilhermebrandao.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(
                                System.currentTimeMillis(),
                                status.value(),
                                status.getReasonPhrase(),
                                exception.getMessage(),
                                request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidPassword.class)
    public ResponseEntity<StandardError> invalidPassword(InvalidPassword exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
