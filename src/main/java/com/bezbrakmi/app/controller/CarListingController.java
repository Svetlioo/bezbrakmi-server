package com.bezbrakmi.app.controller;

import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.service.ICarListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/listing")
public class CarListingController {
    ICarListingService carListingService;

    @Autowired
    public CarListingController(ICarListingService carListingService) {
        this.carListingService = carListingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarListing> getCarListingById(@PathVariable UUID id) {
        Optional<CarListing> carListing = carListingService.getCarListingById(id);
        return carListing.map(listing ->
                new ResponseEntity<>(listing, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<?> addNewCarListing() {
        try {
            carListingService.createNewCarListing();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(e.getMessage()));
        }
    }
}
