package org.satya.exceptionhandling.aspect;

import org.satya.exceptionhandling.dto.ErrorResponse;
import org.satya.exceptionhandling.exception.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e){
        return e.getMessage();
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {

        if (e instanceof MyCustomException){
            ErrorResponse errorResponse = new ErrorResponse("Bad Request Error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        else if( e instanceof RuntimeException) {
            // Create a custom error response
            ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            ErrorResponse errorResponse = new ErrorResponse("Request timedout", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.GATEWAY_TIMEOUT);
        }
    }*/
}
