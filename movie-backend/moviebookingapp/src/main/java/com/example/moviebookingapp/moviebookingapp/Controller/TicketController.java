package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Ticket;
import com.example.moviebookingapp.moviebookingapp.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public boolean deleteTicket(@PathVariable Integer ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/{bookingId}/tickets")
    public List<Ticket> getTicketsForBooking(@PathVariable Integer bookingId) {
        return ticketService.getTicketsForBooking(bookingId);
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable Integer ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @PatchMapping("/{ticketId}/cancel")
    public boolean cancelTicket(@PathVariable Integer ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}
