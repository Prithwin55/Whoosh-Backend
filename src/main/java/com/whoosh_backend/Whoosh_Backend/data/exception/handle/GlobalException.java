package com.whoosh_backend.Whoosh_Backend.data.exception.handle;

import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> otherException(Exception ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> otherException(ResourceAlreadyExistException ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
}
