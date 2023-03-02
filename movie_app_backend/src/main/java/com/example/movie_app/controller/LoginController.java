package com.example.movie_app.controller;

import com.example.movie_app.exceptionHandler.MovieAppException;
import com.example.movie_app.models.User;
import com.example.movie_app.payload.LoginRequest;
import com.example.movie_app.payload.LoginResponse;
import com.example.movie_app.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("v1/login")

    public LoginResponse authenticateuser(@Valid @RequestBody LoginRequest loginRequest) throws MovieAppException {

                User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new MovieAppException("Email not found"));
                System.out.println(user.getPassword());
                if (user.getPassword().equals(loginRequest.getPassword().trim()) ) {

                    LoginResponse loginResponse = new LoginResponse();
                    loginResponse.setEmail(user.getEmail());
                    loginResponse.setUserId(user.getId());
                 loginResponse.setName((user.getName()));

                    return loginResponse;
                } else {
                    throw new MovieAppException("Invalid Password");
                }
            }


}
