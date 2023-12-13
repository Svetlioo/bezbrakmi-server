package com.bezbrakmi.app.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "car_option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "option_id")
    private UUID id;

    @Column(name = "option_name")
    private String name;
}
