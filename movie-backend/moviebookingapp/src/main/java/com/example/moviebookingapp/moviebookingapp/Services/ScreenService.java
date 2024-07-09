package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private TheaterService theaterService;

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public boolean deleteScreen(Integer screenId) {
        screenRepository.deleteById(screenId);
        return true;
    }

    public Screen searchScreen(String screenName) {
        return screenRepository.findByScreenName(screenName);
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public List<Screen> getScreensForTheater(Integer theaterId) {
        Theater theater = theaterService.getTheater(theaterId);
        if (theater != null) {
            return screenRepository.findByTheater(theater);
        }
        return null;
    }

    public List<Show> getShowsForScreen(Integer screenId) {
        Screen screen = screenRepository.findById(screenId).orElse(null);
        if (screen != null) {
            return screen.getShows();
        }
        return null;
    }

    public Screen getScreen(Integer screenId) {
        return screenRepository.findById(screenId).get();
    }
}
