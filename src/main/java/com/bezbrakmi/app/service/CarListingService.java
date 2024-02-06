package com.bezbrakmi.app.service;

import com.bezbrakmi.app.dto.CarListingDTO;
import com.bezbrakmi.app.entity.CarListing;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarListingService {
    Optional<CarListing> getCarListingById(UUID id);

    void createNewCarListing(@Valid CarListingDTO carListingDTO);

    List<CarListing> getAllCarListings();
}
