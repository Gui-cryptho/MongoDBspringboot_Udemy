package com.guilherme.workshopspring_mongodb.resources.exceptions;

import com.guilherme.workshopspring_mongodb.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
