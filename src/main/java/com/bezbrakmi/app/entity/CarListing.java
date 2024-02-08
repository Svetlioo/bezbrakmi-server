package com.bezbrakmi.app.entity;

import com.bezbrakmi.app.model.BaseDatedEntity;
import com.bezbrakmi.app.model.BodyType;
import com.bezbrakmi.app.model.CarBrand;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name = "car_listing")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CarListing extends BaseDatedEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarBrand brand;

    @Column(nullable = false)
    private String model;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BodyType bodyType;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String engine;

    @Column(nullable = false)
    private Integer engineSizeCC;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer horsePower;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
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
    private String contactNumber;

    @Column(nullable = false)
    @Builder.Default
    private Boolean expired = false;

    @Column(nullable = false)
    @Builder.Default
    private Integer views = 0;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_listing_id")
    private Set<CarOption> carOptions;

    @Column(nullable = false)
    private String steeringWheelPosition;


}
