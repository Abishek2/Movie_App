package com.example.movie_app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovieAppException extends Throwable {
    public MovieAppException(String message) {
        super();
    }

    public MovieAppException(String message, Throwable cause) {
        super();
    }

    public MovieAppException(Throwable cause) {
        super();
    }


    public String getMessage() {
        return null;
    }
}
