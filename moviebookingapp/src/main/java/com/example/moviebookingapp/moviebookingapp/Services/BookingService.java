package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Booking;
import com.example.moviebookingapp.moviebookingapp.Entities.BookingStatus;
import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowService showService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private TicketService ticketService;

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public boolean deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
        return true;
    }

    public List<Booking> getBookingsForShow(Integer showId) {
        Show show = showService.getShow(showId);
        if (show!= null) {
            return bookingRepository.findByShow(show);
        }
        return null;
    }

    public List<Booking> getBookingsForMovie(Integer movieId) {
        Movie movie = movieService.getMovie(movieId);
        if (movie!= null) {
            return bookingRepository.findByMovie(movie);
        }
        return null;
    }

    public Booking getBookingByTransactionId(Integer transactionId) {
        return bookingRepository.findByTransactionId(transactionId);
    }

    public boolean cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking!= null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }

    public boolean updateBookingStatus(Integer bookingId, BookingStatus bookingStatus) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking!= null) {
            booking.setBookingStatus(bookingStatus);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }
}
