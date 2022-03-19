package com.javaminds.springbootiq.product.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductNotFoundException extends RuntimeException{
    public static final long serialVersion = 1L;
    public ProductNotFoundException(){
        log.info("In ProductNotFoundException.constructor");
    }
}
