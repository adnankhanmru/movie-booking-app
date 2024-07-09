package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    Screen findByScreenName(String screenName);
    List<Screen> findByTheater(Theater theater);
}
