package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ScreenService screenService;
    @Autowired
    private MovieService movieService;

    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public boolean deleteTheater(Integer theaterId) {
        theaterRepository.deleteById(theaterId);
        return true;
    }

    public Theater searchTheater(String theaterName) {
        return theaterRepository.findByTheaterName(theaterName);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public List<Theater> getTheatersByCity(String theaterCity) {
        return theaterRepository.findByTheaterCity(theaterCity);
    }

    public List<Screen> getScreensForTheater(Integer theaterId) {
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        if (theater!= null) {
            return theater.getScreens();
        }
        return null;
    }

    public List<Movie> getMoviesForTheater(Integer theaterId) {
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        if (theater!= null) {
            return theater.getMovies();
        }
        return null;
    }

    public Theater getTheater(Integer theaterId) {
        return theaterRepository.findById(theaterId).get();
    }
}
