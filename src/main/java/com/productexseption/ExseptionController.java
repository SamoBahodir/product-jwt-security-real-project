package com.productexseption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExseptionController {

    @ExceptionHandler(value = ExtRuntime.class)
    public ResponseEntity updatePro(){
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
