package com.bezbrakmi.app.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "car_model_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @Column(name = "car_model_name")
    private String name;
}
