package com.bezbrakmi.app.repository;

import com.bezbrakmi.app.entity.CarListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarListingRepository extends JpaRepository<CarListing, UUID> {
}
