package com.example.FishingTracker.repository;

import com.example.FishingTracker.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom methods can be defined here if needed
}
