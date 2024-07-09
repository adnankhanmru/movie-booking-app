package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Booking;
import com.example.moviebookingapp.moviebookingapp.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByBooking(Booking booking);
    Ticket findByTicketId(Integer ticketId);
}
