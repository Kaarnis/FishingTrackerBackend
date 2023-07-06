package com.example.FishingTracker.Controller;

import com.example.FishingTracker.Entities.Catch;
import com.example.FishingTracker.Services.CatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/catches")
public class CatchController {
    private final CatchService catchService;

    public CatchController(CatchService catchService) {
        this.catchService = catchService;
    }

    @PostMapping
    public ResponseEntity<Catch> createCatch(@RequestBody Catch newCatch) {
        Catch createdCatch = catchService.createCatch(newCatch);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCatch);
    }

    // Add other catch-related API endpoints here
}

