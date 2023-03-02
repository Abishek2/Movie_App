package com.example.movie_app.controller;

import com.example.movie_app.exceptionHandler.MovieAppException;
import com.example.movie_app.models.User;
import com.example.movie_app.payload.SignUpRequest;
import com.example.movie_app.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SignUpController {
    private final UserRepository userRepository;


    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("v1/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signupRequest) throws MovieAppException {
        User user = new User(signupRequest.getEmail(),signupRequest.getPassword(),signupRequest.getName());
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            throw new MovieAppException("Email already exist");
        }
        else{
            userRepository.save(user);
            return new ResponseEntity<String>("User Created Successfully", HttpStatus.OK);
        }

    }

}
