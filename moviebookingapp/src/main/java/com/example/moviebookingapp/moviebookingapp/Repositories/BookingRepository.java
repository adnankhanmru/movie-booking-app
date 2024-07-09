package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Booking;
import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByShow(Show show);
    List<Booking> findByMovie(Movie movie);
    Booking findByTransactionId(Integer transactionId);
}
