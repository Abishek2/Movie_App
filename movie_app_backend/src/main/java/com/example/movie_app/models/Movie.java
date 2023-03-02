package com.example.movie_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("movie_list")
public class Movie {
@Id
private String id;
private String movieName;
private String cast;
private String director;
private String image;
private String language;
}
