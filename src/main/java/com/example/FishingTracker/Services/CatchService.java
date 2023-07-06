package com.example.FishingTracker.Services;

import com.example.FishingTracker.Entities.Catch;
import com.example.FishingTracker.repository.CatchRepository;
import org.springframework.stereotype.Service;

@Service
public class CatchService {

    private final CatchRepository catchRepository;

    public CatchService(CatchRepository catchRepository) {
        this.catchRepository = catchRepository;
    }
    public Catch createCatch(Catch newCatch) {
        return catchRepository.save(newCatch);
    }
}