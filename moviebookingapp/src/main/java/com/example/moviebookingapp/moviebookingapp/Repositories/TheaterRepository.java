package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByTheaterName(String theaterName);
    List<Theater> findByTheaterCity(String theaterCity);

    List<Theater> findByMovie(Movie movie);
}
