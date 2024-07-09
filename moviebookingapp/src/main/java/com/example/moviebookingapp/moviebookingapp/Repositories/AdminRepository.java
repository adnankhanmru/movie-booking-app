package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByAdminNameAndPassword(String adminName, String password);
}
