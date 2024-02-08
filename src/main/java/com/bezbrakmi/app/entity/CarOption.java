package com.bezbrakmi.app.entity;

import com.bezbrakmi.app.model.BaseEntity;
import com.bezbrakmi.app.model.OptionCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car_option")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CarOption extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private OptionCategory category;

}
