package com.bezbrakmi.app.entity;

import com.bezbrakmi.app.model.OptionCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "car_option")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarOption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private OptionCategory category;


}
