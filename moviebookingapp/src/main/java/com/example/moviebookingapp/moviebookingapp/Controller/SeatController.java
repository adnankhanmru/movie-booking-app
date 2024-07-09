package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.BookingStatus;
import com.example.moviebookingapp.moviebookingapp.Entities.Seat;
import com.example.moviebookingapp.moviebookingapp.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping
    public Seat addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);
    }

    @DeleteMapping("/{seatId}")
    public boolean deleteSeat(@PathVariable Integer seatId) {
        return seatService.deleteSeat(seatId);
    }

    @GetMapping("/{showId}/seats")
    public List<Seat> getSeatsForShow(@PathVariable Integer showId) {
        return seatService.getSeatsForShow(showId);
    }

    @GetMapping("/{showId}/available-seats")
    public List<Seat> getAvailableSeatsForShow(@PathVariable Integer showId) {
        return seatService.getAvailableSeatsForShow(showId);
    }

    @PatchMapping("/{seatId}/block")
    public boolean blockSeat(@PathVariable Integer seatId) {
        return seatService.blockSeat(seatId);
    }

    @PatchMapping("/{seatId}/update-status")
    public boolean updateSeatStatus(@PathVariable Integer seatId, @RequestBody BookingStatus seatStatus) {
        return seatService.updateSeatStatus(seatId,seatStatus);
    }
}
