package com.example.movie_app.controller;

import com.example.movie_app.models.Movie;
import com.example.movie_app.repository.MovieListRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MovieController {
    private final MovieListRepository movieListRepository;

    public MovieController(MovieListRepository movieListRepository) {
        this.movieListRepository = movieListRepository;
    }
    @GetMapping("v1/movie_list")

    public List<Movie> getMovie(Movie movie){
        return movieListRepository.findAll();
    }
}
