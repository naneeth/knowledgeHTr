package com.stackroute.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This class is for handling exception globally
@ControllerAdvice
public class GlobalExceptionHandler {


    //This exception is when File is not Found
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity userAlreadyExistsException(final FileNotFoundException e) {
        return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //This Exception is for checking Empty File
    @ExceptionHandler(EmptyFileException.class)
    public ResponseEntity userAlreadyExistsException(final EmptyFileException e) {
        return  new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
}
