package com.example.FishingTracker.service;

import com.example.FishingTracker.Entities.Catch;
import com.example.FishingTracker.Services.CatchService;
import com.example.FishingTracker.repository.CatchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
class CatchServiceTest {

    @Mock
    private CatchRepository catchRepository;

    private CatchService catchService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        catchService = new CatchService(catchRepository);
    }

    @Test
    void testCreateCatch() {
        // Create a sample catch
        Catch newCatch = new Catch();
        newCatch.setFishSpecies("Bass");
        newCatch.setWeight(2.5);
        newCatch.setLength(40.0);

        // Set up the behavior of the catchRepository.save() method
        Catch savedCatch = new Catch();
        savedCatch.setId(1L);
        savedCatch.setFishSpecies(newCatch.getFishSpecies());
        savedCatch.setWeight(newCatch.getWeight());
        savedCatch.setLength(newCatch.getLength());
        when(catchRepository.save(any(Catch.class))).thenReturn(savedCatch);

        // Call the createCatch() method
        Catch createdCatch = catchService.createCatch(newCatch);

        // Verify that the catchRepository.save() method was called with the newCatch object
        verify(catchRepository, times(1)).save(newCatch);

        // Assertions
        Assertions.assertNotNull(createdCatch);
        Assertions.assertEquals(savedCatch.getId(), createdCatch.getId());
        Assertions.assertEquals(savedCatch.getFishSpecies(), createdCatch.getFishSpecies());
        Assertions.assertEquals(savedCatch.getWeight(), createdCatch.getWeight());
        Assertions.assertEquals(savedCatch.getLength(), createdCatch.getLength());
    }
}