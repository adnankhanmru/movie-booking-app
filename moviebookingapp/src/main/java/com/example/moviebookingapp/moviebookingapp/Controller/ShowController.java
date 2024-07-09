package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @DeleteMapping("/{showId}")
    public boolean deleteShow(@PathVariable Integer showId) {
        return showService.deleteShow(showId);
    }

    @GetMapping("/{showName}")
    public Show searchShow(@PathVariable String showName) {
        return showService.searchShow(showName);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{movieId}/shows")
    public List<Show> getShowsForMovie(@PathVariable Integer movieId) {
        return showService.getShowsForMovie(movieId);
    }

    @GetMapping("/{screenId}/shows")
    public List<Show> getShowsForScreen(@PathVariable Integer screenId) {
        return showService.getShowsForScreen(screenId);
    }

    @PostMapping("/{showId}/book-seat")
    public boolean bookSeat(@PathVariable Integer showId, @RequestBody Integer seatId) {
        return showService.bookSeat(showId, seatId);
    }

    @PostMapping("/{showId}/cancel-seat-booking")
    public boolean cancelSeatBooking(@PathVariable Integer showId, @RequestBody Integer seatId) {
        return showService.cancelSeatBooking(showId, seatId);
    }
}
