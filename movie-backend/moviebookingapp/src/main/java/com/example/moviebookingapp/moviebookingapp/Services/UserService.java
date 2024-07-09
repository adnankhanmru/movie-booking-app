package com.example.moviebookingapp.moviebookingapp.Services;

import com.example.moviebookingapp.moviebookingapp.Entities.User;
import com.example.moviebookingapp.moviebookingapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setLoggedIn(false);
        return userRepository.save(user);
    }

    public boolean signIn(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user!= null) {
            user.setLoggedIn(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean signOut(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user!= null) {
            user.setLoggedIn(false);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}