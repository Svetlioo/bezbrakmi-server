package com.bezbrakmi.app.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "car_brand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "car_brand_id")
    private UUID id;

    @Column(name = "car_brand_name")
    private String name;

}
