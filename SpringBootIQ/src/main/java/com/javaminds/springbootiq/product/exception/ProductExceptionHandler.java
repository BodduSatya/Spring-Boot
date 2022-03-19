package com.javaminds.springbootiq.product.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ProductExceptionHandler {

    @ExceptionHandler(value=ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException ex){
        log.info("In ProductExceptionHandler.exception()");
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=NullPointerException.class)
    public ResponseEntity<Object> exception(NullPointerException ex){
        log.info("In ProductExceptionHandler.exception()");
        return new ResponseEntity<>("something went wrong",HttpStatus.NOT_FOUND);
    }
}


