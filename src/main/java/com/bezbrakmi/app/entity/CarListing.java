package com.bezbrakmi.app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(schema = "car_listing")
public class CarListing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "car_listing_id")
    private UUID id;

    @Column(name = "car_listing_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @Column(name = "car_listing_description")
    private String description;

    @Column(name = "car_listing_date")
    private LocalDateTime date;


    @ManyToMany
    @JoinTable(
            name = "car_listing_options",
            joinColumns = @JoinColumn(name = "car_listing_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<Option> carOptions;




    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public CarListing() {
    }
}
