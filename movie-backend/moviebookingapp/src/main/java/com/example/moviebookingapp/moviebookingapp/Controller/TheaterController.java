package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public Theater addTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @DeleteMapping("/{theaterId}")
    public boolean deleteTheater(@PathVariable Integer theaterId) {
        return theaterService.deleteTheater(theaterId);
    }

    @GetMapping("/{theaterName}")
    public Theater searchTheater(@PathVariable String theaterName) {
        return theaterService.searchTheater(theaterName);
    }

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("/city/{theaterCity}")
    public List<Theater> getTheatersByCity(@PathVariable String theaterCity) {
        return theaterService.getTheatersByCity(theaterCity);
    }

    @GetMapping("/{theaterId}/screens")
    public List<Screen> getScreensForTheater(@PathVariable Integer theaterId) {
        return theaterService.getScreensForTheater(theaterId);
    }

    @GetMapping("/{theaterId}/movies")
    public List<Movie> getMoviesForTheater(@PathVariable Integer theaterId) {
        return theaterService.getMoviesForTheater(theaterId);
    }
}
