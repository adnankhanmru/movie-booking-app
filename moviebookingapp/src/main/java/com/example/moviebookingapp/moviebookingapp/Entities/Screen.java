package com.example.moviebookingapp.moviebookingapp.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;
    private String screenName;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Show> shows;
}
