package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.BookingStatus;
import com.example.moviebookingapp.moviebookingapp.Entities.Seat;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowService showService;

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public boolean deleteSeat(Integer seatId) {
        seatRepository.deleteById(seatId);
        return true;
    }

    public List<Seat> getSeatsForShow(Integer showId) {
        Show show = showService.getShow(showId);
        if (show != null) {
            return seatRepository.findByShow(show);
        }
        return null;
    }

    public List<Seat> getAvailableSeatsForShow(Integer showId) {
        Show show = showService.getShow(showId);
        if (show != null) {
            return seatRepository.findByShowAndSeatStatus(show, BookingStatus.AVAILABLE);
        }
        return null;
    }

    public boolean blockSeat(Integer seatId) {
        Seat seat = seatRepository.findById(seatId).orElse(null);
        if (seat != null) {
            seat.setSeatStatus(BookingStatus.BLOCKED);
            seatRepository.save(seat);
            return true;
        }
        return false;
    }

    public boolean updateSeatStatus(Integer seatId, BookingStatus seatStatus) {
        Seat seat = seatRepository.findById(seatId).orElse(null);
        if (seat != null) {
            seat.setSeatStatus(seatStatus);
            seatRepository.save(seat);
            return true;
        }
        return false;
    }
}
