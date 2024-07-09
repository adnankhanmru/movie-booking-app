package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private Time showStartTime;
    private Time showEndTime;
    private String showName;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

}
