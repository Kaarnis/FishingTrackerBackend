package com.example.FishingTracker.Services;

import com.example.FishingTracker.Entities.FishingTrip;
import com.example.FishingTracker.repository.FishingTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingTripService {

    @Autowired
    private final FishingTripRepository fishingTripRepository;

public FishingTripService(FishingTripRepository fishingTripRepository) {
        this.fishingTripRepository = fishingTripRepository;
    }

    public List<FishingTrip> getAllFishingTrips() {
        return fishingTripRepository.findAll();
    }

    public FishingTrip getFishingTripById(Long id) {
        return fishingTripRepository.findById(id).orElse(null);
    }

    public FishingTrip createFishingTrip(FishingTrip fishingTrip) {
        return fishingTripRepository.save(fishingTrip);
    }

    public FishingTrip updateFishingTrip(Long id, FishingTrip updatedFishingTrip) {
        FishingTrip fishingTrip = fishingTripRepository.findById(id).orElse(null);
        if (fishingTrip != null) {
            // Update the fishing trip properties
            fishingTrip.setName(updatedFishingTrip.getName());
            fishingTrip.setLocation(updatedFishingTrip.getLocation());
            // ... update other properties as needed

            return fishingTripRepository.save(fishingTrip);
        } else {
            return null;
        }
    }
    public boolean deleteFishingTrip(Long id) {
        FishingTrip fishingTrip = fishingTripRepository.findById(id).orElse(null);
        if (fishingTrip != null) {
            fishingTripRepository.delete(fishingTrip);
            return true;
        } else {
            return false;
        }
    }
}
