package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    List<Show> findByMovie(Movie movie);
    List<Show> findByScreen(Screen screen);
    Show findByShowName(String showName);
}
