package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Customer;
import com.example.moviebookingapp.moviebookingapp.Entities.Ticket;
import com.example.moviebookingapp.moviebookingapp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer registerNewCustomer(@RequestBody Customer customer) {
        return customerService.registerNewCustomer(customer);
    }

    @PostMapping("/signin")
    public boolean signin(@RequestBody String customerName, @RequestBody String password) {
        return customerService.signin(customerName, password);
    }

    @PostMapping("/signout")
    public boolean signOut() {
        return customerService.signOut();
    }

    @GetMapping("/{userId}")
    public Customer getCustomer(@PathVariable Integer userId) {
        return customerService.getCustomer(userId);
    }

    @GetMapping("/{userId}/my-tickets")
    public List<Ticket> getMyTickets(@PathVariable Integer userId) {
        return customerService.getMyTickets(userId);
    }

    @PostMapping("/{userId}/book-movie-ticket")
    public boolean bookMovieTicket(@PathVariable Integer userId, @RequestBody Integer theaterId) {
        return customerService.bookMovieTicket(userId, theaterId);
    }

    @PostMapping("/{userId}/cancel-movie-ticket")
    public boolean cancelMovieTicket(@PathVariable Integer userId, @RequestBody Integer ticketId) {
        return customerService.cancelMovieTicket(userId, ticketId);
    }

    @PostMapping("/choose-city")
    public boolean chooseCity(@RequestBody String city) {
        return customerService.chooseCity(city);
    }
}
