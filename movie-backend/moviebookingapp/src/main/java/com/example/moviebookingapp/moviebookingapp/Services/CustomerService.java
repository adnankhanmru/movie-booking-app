package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Customer;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Entities.Ticket;
import com.example.moviebookingapp.moviebookingapp.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TheaterService theaterService;


    public Customer registerNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean signin(String customerName, String password) {
        Customer customer = customerRepository.findByCustomerName(customerName);
        return customer != null && customer.getPassword().equals(password);
    }

    public boolean signOut() {
        Customer customer = getCurrentCustomer();
        return customer != null;
    }

    public Customer getCustomer(Integer userId) {
        return customerRepository.findByUserId(userId);
    }

    public List<Ticket> getMyTickets(Integer userId) {
        Customer customer = getCustomer(userId);
        if (customer != null) {
            return customer.getMyTickets();
        }
        return null;
    }

    public boolean bookMovieTicket(Integer userId, Integer theaterId) {
        Customer customer = getCustomer(userId);
        if (customer != null) {
            Theater theater = theaterService.getTheater(theaterId);
            if (theater != null) {
                // Book the ticket
                Ticket ticket = new Ticket();
                ticket.setCustomer(customer);
                ticket.setTheater(theater);
                ticketService.addTicket(ticket);
                return true;
            }
        }
        return false;
    }

    public boolean cancelMovieTicket(Integer userId, Integer ticketId) {
        Customer customer = getCustomer(userId);
        if (customer != null) {
            Ticket ticket = ticketService.getTicket(ticketId);
            if (ticket != null && ticket.getCustomer().equals(customer)) {
                ticketService.cancelTicket(ticketId);
                return true;
            }
        }
        return false;
    }

    public boolean chooseCity(String city) {
        return true;
    }

    private Customer getCurrentCustomer() {
        // Get the current user from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String customerName = authentication.getName();
            return customerRepository.findByCustomerName(customerName);
        }
        return null;
    }
}