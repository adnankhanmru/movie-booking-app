package com.example.moviebookingapp.moviebookingapp.Controller;

import com.example.moviebookingapp.moviebookingapp.Entities.*;
import com.example.moviebookingapp.moviebookingapp.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerNewAdmin(@RequestBody Admin admin) {
        return adminService.registerNewAdmin(admin.getAdminName(), admin.getPassword());
    }

    @PostMapping("/signin")
    public boolean signIn(@RequestBody Admin admin) {
        return adminService.signIn(admin.getAdminName(), admin.getPassword());
    }

    @PostMapping("/signout")
    public boolean signOut() {
        return adminService.signOut();
    }

    @PostMapping("/addTheater")
    public Theater addTheater(@RequestBody Theater theater) {
        return adminService.addTheater(theater);
    }

    @PostMapping("/deleteTheater/{theaterId}")
    public boolean deleteTheater(@PathVariable Integer theaterId) {
        return adminService.deleteTheater(theaterId);
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return adminService.addMovie(movie);
    }

    @PostMapping("/deleteMovie/{movieId}")
    public boolean deleteMovie(@PathVariable Integer movieId) {
        return adminService.deleteMovie(movieId);
    }

    @PostMapping("/addScreen")
    public Screen addScreen(@RequestBody Screen screen) {
        return adminService.addScreen(screen);
    }

    @PostMapping("/deleteScreen/{screenId}")
    public boolean deleteScreen(@PathVariable Integer screenId) {
        return adminService.deleteScreen(screenId);
    }

    @PostMapping("/addShow")
    public Show addShow(@RequestBody Show show) {
        return adminService.addShow(show);
    }
}
