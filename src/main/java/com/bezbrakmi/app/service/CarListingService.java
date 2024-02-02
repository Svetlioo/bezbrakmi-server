package com.bezbrakmi.app.service;

import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.entity.Option;
import com.bezbrakmi.app.repository.CarListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class CarListingService implements ICarListingService {
    CarListingRepository carListingRepository;

    @Autowired
    public CarListingService(CarListingRepository carListingRepository) {
        this.carListingRepository = carListingRepository;
    }

    @Override
    public Optional<CarListing> getCarListingById(UUID id) {
        return carListingRepository.findById(id);
    }

    @Override
    public void createNewCarListing() {

    }
}
