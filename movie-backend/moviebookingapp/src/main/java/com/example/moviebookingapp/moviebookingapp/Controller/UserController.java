package com.example.moviebookingapp.moviebookingapp.Controller;


import com.example.moviebookingapp.moviebookingapp.Entities.User;
import com.example.moviebookingapp.moviebookingapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user.getUserName(), user.getPassword());
    }

    @PostMapping("/signin")
    public boolean signIn(@RequestBody User user) {
        return userService.signIn(user.getUserName(), user.getPassword());
    }

    @PostMapping("/signout")
    public boolean signOut(@RequestHeader("userId") Integer userId) {
        return userService.signOut(userId);
    }
}