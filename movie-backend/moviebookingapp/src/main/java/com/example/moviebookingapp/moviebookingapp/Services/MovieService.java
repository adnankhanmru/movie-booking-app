package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Repositories.MovieRepository;
import com.example.moviebookingapp.moviebookingapp.Repositories.ScreenRepository;
import com.example.moviebookingapp.moviebookingapp.Repositories.ShowRepository;
import com.example.moviebookingapp.moviebookingapp.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;


    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Integer movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }

    public Movie searchMovie(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

    public Movie getMovie(Integer movieId ) {
        return movieRepository.findById(movieId).get();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Show> getShowsForMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null)
            return showRepository.findByMovie(movie);
        return null;
    }

    public List<Theater> getTheatersForMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            return theaterRepository.findByMovie(movie);
        }
        return null;
    }
}
