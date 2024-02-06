package com.bezbrakmi.app.dto;

import com.bezbrakmi.app.model.BodyType;
import com.bezbrakmi.app.model.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarListingDTO {
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    private String model;

    @Length(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    private BodyType bodyType;

    @Positive(message = "Value must be positive")
    private Integer price;

    private String engine;

    private Integer engineSizeCC;

    private String condition;

    @Min(value = 1960, message = "Year must be greater than 1900")
    @Max(value = 2024, message = "Future year is not allowed")
    private Integer year;

    @Positive(message = "Horsepower must be positive")
    private Integer horsePower;

    private String fuelType;

    private String transmission;

    private String location;

    @Positive(message = "Mileage must be positive")
    private Integer mileage;

    private String sellerType;

    private String doorCount;

    private String color;

    private String euroCategory;

    private String contactNumber;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_listing_id")
    private Set<CarOptionDTO> carOptions;

    private String steeringWheelPosition;


}
