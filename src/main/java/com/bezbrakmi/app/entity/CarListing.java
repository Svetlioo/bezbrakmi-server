package com.bezbrakmi.app.entity;

import com.bezbrakmi.app.model.BodyType;
import com.bezbrakmi.app.model.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table (name = "car_listing")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarListing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarBrand brand;

    @Column(nullable = false)
    private String model;

    @Length(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BodyType bodyType;

    @Positive(message = "Value must be positive")
    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String engine;

    @Column(nullable = false)
    private Integer engineSizeCC;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    @Min(value = 1960, message = "Year must be greater than 1900")
    @Max(value = 2024, message = "Future year is not allowed")
    private Integer year;

    @Column(nullable = false)
    @Positive(message = "Horsepower must be positive")
    private Integer horsePower;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @Positive(message = "Mileage must be positive")
    private Integer mileage;

    @Column(nullable = false)
    private String sellerType;

    @Column(nullable = false)
    private String doorCount;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String euroCategory;

    @Column(nullable = false)
    private LocalDate dateAdded;

    @Column(nullable = false)
    private Integer views;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private Boolean expired;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_listing_id")
    private Set<CarOption> carOptions;

    @Column(nullable = false)
    private String steeringWheelPosition;

    @PrePersist
    public void prePersist() {
        // Set default values before persisting the entity
        if (dateAdded == null) {
            dateAdded = LocalDate.now();
        }

        if (views == null) {
            views = 0;
        }

        if (expired == null) {
            expired = false;
        }
    }



}
