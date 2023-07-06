package com.example.FishingTracker.repository;

import com.example.FishingTracker.Entities.Catch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchRepository extends JpaRepository<Catch, Long> {

    // Additional custom methods can be defined here if needed
}

