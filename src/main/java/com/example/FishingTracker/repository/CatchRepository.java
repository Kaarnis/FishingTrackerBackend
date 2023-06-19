package com.example.FishingTracker.repository;

import com.example.FishingTracker.Entities.FishingTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchRepository extends JpaRepository<FishingTrip, Long> {

    // Additional custom methods can be defined here if needed
}

