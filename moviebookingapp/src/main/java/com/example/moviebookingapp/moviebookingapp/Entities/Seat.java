package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private String seatName;

    @Enumerated(EnumType.STRING)
    private BookingStatus seatStatus;
    private Double seatPrice;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}
