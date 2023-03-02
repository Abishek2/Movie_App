package com.example.movie_app.repository;

import com.example.movie_app.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieListRepository extends MongoRepository<Movie,String> {
}
