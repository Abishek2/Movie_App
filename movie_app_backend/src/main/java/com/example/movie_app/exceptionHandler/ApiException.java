package com.example.movie_app.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    private  String message;
    private  Object body;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

}
