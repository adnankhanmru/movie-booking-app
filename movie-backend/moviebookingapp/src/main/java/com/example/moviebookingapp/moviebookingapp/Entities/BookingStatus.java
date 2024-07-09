package com.example.moviebookingapp.moviebookingapp.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum BookingStatus{
    AVAILABLE("Available"),
    BOOKED("Booked"),
    BLOCKED("Blocked");

    private final String description;

    BookingStatus(String description) {
        this.description = description;
    }
}
