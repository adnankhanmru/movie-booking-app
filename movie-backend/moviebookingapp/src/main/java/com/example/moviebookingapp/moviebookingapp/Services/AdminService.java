package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.*;
import com.example.moviebookingapp.moviebookingapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private BookingRepository bookingRepository;

    private Admin currentAdmin;

    public Admin registerNewAdmin(String adminName, String password) {
        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setPassword(password);
        return adminRepository.save(admin);
    }

    public boolean signIn(String adminName, String password) {
        Admin admin = adminRepository.findByAdminNameAndPassword(adminName, password);
        if (admin!= null) {
            currentAdmin  = admin;
            return true;
        }
        return false;
    }

    public boolean signOut() {
        if (currentAdmin!= null) {
            currentAdmin = null;
            return true;
        }
        return false;
    }


    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public boolean deleteTheater(Integer theaterId) {
        theaterRepository.deleteById(theaterId);
        return true;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Integer movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public boolean deleteScreen(Integer screenId) {
        screenRepository.deleteById(screenId);
        return true;
    }

    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public boolean deleteShow(Integer showId) {
        showRepository.deleteById(showId);
        return true;
    }

    public Screen searchScreen(Integer screenId) {
        return screenRepository.findById(screenId).orElse(null);
    }

    public Show searchShow(String movieName) {
        return showRepository.findByShowName(movieName);
                //findByMovieName(movieName);
    }

    public Seat[] chooseSeats(String[] seatNames) {
        List<Seat> seats = new ArrayList<>();
        for (String seatName : seatNames) {
            Seat seat = seatRepository.findBySeatName(seatName);
            if (seat!= null) {
                seats.add(seat);
            }
        }
        return seats.toArray(new Seat[0]);
    }

    public boolean updateSeatsStatus(String[] seatNames) {
        for (String seatName : seatNames) {
            Seat seat = seatRepository.findBySeatName(seatName);
            if (seat!= null) {
                seat.setSeatStatus(BookingStatus.BOOKED);
                seatRepository.save(seat);
            }
        }
        return true;
    }

    public Booking initiateBooking(Seat[] seats, Show show) {
        Booking booking = new Booking();
        //booking.setShowRef(show);
        booking.setSeats(Arrays.asList(seats));
        return bookingRepository.save(booking);
    }

    public boolean cancelTickets(Seat[] seats) {
        for (Seat seat : seats) {
            seat.setSeatStatus(BookingStatus.AVAILABLE);
            seatRepository.save(seat);
        }
        return true;
    }
}
