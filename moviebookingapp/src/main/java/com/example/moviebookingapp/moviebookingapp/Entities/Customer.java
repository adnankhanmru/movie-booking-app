package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String customerName;
    private String password;
    private LocalDate dateOfBirth;
    private String customerCity;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> myTickets;
    private String customerContact;

    // getters and setters
}
