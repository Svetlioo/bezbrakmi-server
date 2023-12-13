package com.bezbrakmi.app.service;

import com.bezbrakmi.app.entity.CarListing;

import java.util.Optional;
import java.util.UUID;

public interface ICarListingService {
    Optional<CarListing> getCarListingById(UUID id);

    void createNewCarListing();
}
