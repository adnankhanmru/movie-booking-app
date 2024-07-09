package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.*;
import com.example.moviebookingapp.moviebookingapp.Repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreenService screenService;


    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public boolean deleteShow(Integer showId) {
        showRepository.deleteById(showId);
        return true;
    }

    public Show searchShow(String showName) {
        return showRepository.findByShowName(showName);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getShowsForMovie(Integer movieId) {
        Movie movie = movieService.getMovie(movieId);
        if (movie != null) {
            return showRepository.findByMovie(movie);
        }
        return null;
    }

    public List<Show> getShowsForScreen(Integer screenId) {
        Screen screen = screenService.getScreen(screenId);
        if (screen != null) {
            return showRepository.findByScreen(screen);
        }
        return new ArrayList<>();
    }

    public boolean bookSeat(Integer showId, Integer seatId) {
        Show show = showRepository.findById(showId).orElse(null);
        if (show != null) {
            Seat seat = show.getSeats().stream().filter(s -> s.getSeatId().equals(seatId)).findFirst().orElse(null);
            if (seat != null) {
                seat.setSeatStatus(BookingStatus.BOOKED);
                return true;
            }
        }
        return false;
    }

    public boolean cancelSeatBooking(Integer showId, Integer seatId) {
        Show show = showRepository.findById(showId).orElse(null);
        if (show != null) {
            Seat seat = show.getSeats().stream().filter(s -> s.getSeatId().equals(seatId)).findFirst().orElse(null);
            if (seat != null) {
                seat.setSeatStatus(BookingStatus.AVAILABLE);
                return true;
            }
        }
        return false;
    }

    public Show getShow(Integer showId) {
        return showRepository.findById(showId).get();
    }
}
