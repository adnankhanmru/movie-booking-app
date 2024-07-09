package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String movieName;
    private String movieGenre;
    private String movieDirector;
    private Integer movieLength;

    @ElementCollection
    private List<String> languages;
    private Date movieReleaseDate;


}
