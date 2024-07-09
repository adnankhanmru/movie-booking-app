package com.example.moviebookingapp.moviebookingapp.Repositories;

import com.example.moviebookingapp.moviebookingapp.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUserId(Integer userId);
    Customer findByCustomerName(String customerName);
}
