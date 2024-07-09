package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.BookingStatus;
import com.example.moviebookingapp.moviebookingapp.Entities.Seat;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByShow(Show show);
    List<Seat> findBySeatStatus(BookingStatus seatStatus);

    Seat findBySeatName(String seatName);

    List<Seat> findByShowAndSeatStatus(Show show, BookingStatus bookingStatus);
}
