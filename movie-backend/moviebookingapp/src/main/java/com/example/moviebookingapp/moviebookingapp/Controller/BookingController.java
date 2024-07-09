package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Booking;
import com.example.moviebookingapp.moviebookingapp.Entities.BookingStatus;
import com.example.moviebookingapp.moviebookingapp.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @DeleteMapping("/{bookingId}")
    public boolean deleteBooking(@PathVariable Integer bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/{showId}/bookings")
    public List<Booking> getBookingsForShow(@PathVariable Integer showId) {
        return bookingService.getBookingsForShow(showId);
    }

    @GetMapping("/{movieId}/bookings")
    public List<Booking> getBookingsForMovie(@PathVariable Integer movieId) {
        return bookingService.getBookingsForMovie(movieId);
    }

    @GetMapping("/transaction/{transactionId}")
    public Booking getBookingByTransactionId(@PathVariable Integer transactionId) {
        return bookingService.getBookingByTransactionId(transactionId);
    }

    @PatchMapping("/{bookingId}/cancel")
    public boolean cancelBooking(@PathVariable Integer bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    @PatchMapping("/{bookingId}/update-status")
    public boolean updateBookingStatus(@PathVariable Integer bookingId, @RequestBody BookingStatus bookingStatus) {
        return bookingService.updateBookingStatus(bookingId, bookingStatus);
    }
}
