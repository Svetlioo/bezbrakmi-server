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
@RequestMapping("api")
public class CarListingController {
    ICarListingService carListingService;

    @Autowired
    public CarListingController(ICarListingService carListingService) {
        this.carListingService = carListingService;
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity<CarListing> getCarListingById(@PathVariable UUID id) {
        Optional<CarListing> carListing = carListingService.getCarListingById(id);
        if (carListing.isPresent()) {
            return new ResponseEntity<>(carListing.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/listing/add")
    public ResponseEntity<?> addNewCarListing() {
        try {
            carListingService.createNewCarListing();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
