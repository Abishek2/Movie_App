package com.example.movie_app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler  {
    @ExceptionHandler(value = {MovieAppException.class} )
    public ResponseEntity <Object> handleApiRequestException(MovieAppException e){

        ApiException apiException =new ApiException(
                e.getMessage(),
                null, HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleConstraintViolationException(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getFieldErrors();
        Map<String, String> errorMap = new HashMap<>();
        for(FieldError e : fieldErrors) {
            errorMap.put(e.getField(), e.getDefaultMessage());
        }
        ApiException apiException =new ApiException(
                "Invalid Request body",errorMap,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}