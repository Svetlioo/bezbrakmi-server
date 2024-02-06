package com.bezbrakmi.app.service;

import com.bezbrakmi.app.converter.CarListingConverter;
import com.bezbrakmi.app.dto.CarListingDTO;
import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.repository.CarListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CarListingServiceImpl implements CarListingService {
    private final CarListingRepository carListingRepository;

    @Autowired
    public CarListingServiceImpl(CarListingRepository carListingRepository) {
        this.carListingRepository = carListingRepository;
    }


    @Override
    public Optional<CarListing> getCarListingById(UUID id) {
        return carListingRepository.findById(id);
    }

    @Override
    public void createNewCarListing(CarListingDTO carListingDTO) {
        CarListing carListing = CarListingConverter.convertToEntity(carListingDTO);
        carListingRepository.save(carListing);
    }

    @Override
    public List<CarListing> getAllCarListings() {
        return carListingRepository.findAll();
    }


}
