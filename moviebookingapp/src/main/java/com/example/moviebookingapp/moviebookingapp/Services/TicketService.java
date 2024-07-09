package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Booking;
import com.example.moviebookingapp.moviebookingapp.Entities.Ticket;
import com.example.moviebookingapp.moviebookingapp.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BookingService bookingService;

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public boolean deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
        return true;
    }

    public List<Ticket> getTicketsForBooking(Integer bookingId) {
        Booking booking = bookingService.getBookingByTransactionId(bookingId);
        if (booking!= null) {
            return ticketRepository.findByBooking(booking);
        }
        return null;
    }

    public Ticket getTicket(Integer ticketId) {
        return ticketRepository.findByTicketId(ticketId);
    }

    public boolean cancelTicket(Integer ticketId) {
        Ticket ticket = ticketRepository.findByTicketId(ticketId);
        if (ticket!= null) {
            ticket.setTicketStatus(false);
            ticketRepository.save(ticket);
            return true;
        }
        return false;
    }
}
