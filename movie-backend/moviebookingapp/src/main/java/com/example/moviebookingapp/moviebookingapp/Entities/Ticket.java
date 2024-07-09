package com.example.moviebookingapp.moviebookingapp.Entities;

import com.example.moviebookingapp.moviebookingapp.Repositories.CustomerRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Integer noOfSeats;
    private Customer customer;
    private Theater theater;
    @ElementCollection
    private List<String> seatNames;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private Boolean ticketStatus;
    private String screenName;
}
