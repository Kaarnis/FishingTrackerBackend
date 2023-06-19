package com.example.FishingTracker.Controller;

import com.example.FishingTracker.Entities.FishingTrip;
import com.example.FishingTracker.Services.FishingTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FishingTripController {

    @Autowired
    private FishingTripService fishingTripService;

    @GetMapping("/fishing-trips")
    public List<FishingTrip> getAllFishingTrips() {
        return fishingTripService.getAllFishingTrips();
    }

    @GetMapping("/fishing-trips/{id}")
    public ResponseEntity<FishingTrip> getFishingTripById(@PathVariable Long id) {
        FishingTrip fishingTrip = fishingTripService.getFishingTripById(id);
        if (fishingTrip != null) {
            return ResponseEntity.ok(fishingTrip);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/fishing-trips")
    public ResponseEntity<FishingTrip> createFishingTrip(@RequestBody FishingTrip fishingTrip) {
        FishingTrip createdTrip = fishingTripService.createFishingTrip(fishingTrip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    @PutMapping("/fishing-trips/{id}")
    public ResponseEntity<FishingTrip> updateFishingTrip(@PathVariable Long id, @RequestBody FishingTrip fishingTrip) {
        FishingTrip updatedTrip = fishingTripService.updateFishingTrip(id, fishingTrip);
        if (updatedTrip != null) {
            return ResponseEntity.ok(updatedTrip);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/fishing-trips/{id}")
    public ResponseEntity<Void> deleteFishingTrip(@PathVariable Long id) {
        boolean deleted = fishingTripService.deleteFishingTrip(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
