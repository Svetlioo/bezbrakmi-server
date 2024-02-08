package com.bezbrakmi.app.controller;

import com.bezbrakmi.app.dto.CarListingDTO;
import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.service.CarListingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/listing")
public class CarListingController {
    private final CarListingService carListingService;

    @Autowired
    public CarListingController(CarListingService carListingService) {
        this.carListingService = carListingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarListing> getCarListingById(@PathVariable UUID id) {
        Optional<CarListing> carListing = carListingService.getCarListingById(id);
        return carListing.map(listing ->
                new ResponseEntity<>(listing, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<?> getAllCarListings() {
        List<CarListing> carListings = carListingService.getAllCarListings();
        if (carListings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(carListings, HttpStatus.OK);
        }
    }


    @PostMapping()
    public ResponseEntity<?> addNewCarListing(@Valid @RequestBody CarListingDTO carListingDTO) {
        try {
            carListingService.createNewCarListing(carListingDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(e.getMessage()));
        }
    }
}
