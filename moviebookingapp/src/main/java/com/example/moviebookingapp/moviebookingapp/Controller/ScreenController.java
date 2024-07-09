package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.Screen;
import com.example.moviebookingapp.moviebookingapp.Entities.Show;
import com.example.moviebookingapp.moviebookingapp.Services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @PostMapping
    public Screen addScreen(@RequestBody Screen screen) {
        return screenService.addScreen(screen);
    }

    @DeleteMapping("/{screenId}")
    public boolean deleteScreen(@PathVariable Integer screenId) {
        return screenService.deleteScreen(screenId);
    }

    @GetMapping("/{screenName}")
    public Screen searchScreen(@PathVariable String screenName) {
        return screenService.searchScreen(screenName);
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/{theaterId}/screens")
    public List<Screen> getScreensForTheater(@PathVariable Integer theaterId) {
        return screenService.getScreensForTheater(theaterId);
    }

    @GetMapping("/{screenId}/shows")
    public List<Show> getShowsForScreen(@PathVariable Integer screenId) {
        return screenService.getShowsForScreen(screenId);
    }
}
