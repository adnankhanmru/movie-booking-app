package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String movieName;
    private String movieGenre;
    private String movieDirector;
    private Integer movieLength;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ElementCollection
    private List<String> languages;
    private Date movieReleaseDate;


}
