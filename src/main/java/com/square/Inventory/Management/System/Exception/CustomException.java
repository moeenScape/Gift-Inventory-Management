package com.square.Inventory.Management.System.Exception;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.AppinfoDocumentImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomException extends Throwable {


    public ResponseEntity<Map<String ,String >> handleException(MethodArgumentNotValidException ex) {
        Map<String ,String > resp=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String filedError=((FieldError)objectError).getField();
            String message=objectError.getDefaultMessage();
            resp.put(filedError,message);
        });
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
}
