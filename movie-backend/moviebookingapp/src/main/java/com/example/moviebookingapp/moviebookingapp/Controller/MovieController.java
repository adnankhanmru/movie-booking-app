package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{movieId}")
    public boolean deleteMovie(@PathVariable Integer movieId) {
        return movieService.deleteMovie(movieId);
    }

    @GetMapping("/{movieName}")
    public Movie searchMovie(@PathVariable String movieName) {
        return movieService.searchMovie(movieName);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}/shows")
    public ResponseEntity<List<Show>> getShowsForMovie(@PathVariable Integer movieId) {
        try {
            List<Show> shows = movieService.getShowsForMovie(movieId);
            if (shows != null) {
                return new ResponseEntity<>(shows, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{movieId}/theaters")
    public List<Theater> getTheatersForMovie(@PathVariable Integer movieId) {
        return movieService.getTheatersForMovie(movieId);
    }
}
