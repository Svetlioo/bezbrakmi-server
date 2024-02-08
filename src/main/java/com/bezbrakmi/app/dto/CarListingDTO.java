package com.bezbrakmi.app.dto;

import com.bezbrakmi.app.model.BodyType;
import com.bezbrakmi.app.model.CarBrand;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Brand cannot be null")
    private CarBrand brand;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Length(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    @NotNull(message = "Brand cannot be null")
    private BodyType bodyType;

    @Positive(message = "Value must be positive")
    private Integer price;

    @NotBlank(message = "Engine cannot be blank")
    private String engine;

    @Positive(message = "Engine size must be positive")
    private Integer engineSizeCC;

    @NotBlank(message = "Condition cannot be blank")
    private String condition;

    @Min(value = 1960, message = "Year must be greater than 1900")
    @Max(value = 2024, message = "Year must be less than 2024")
    private Integer year;

    @Positive(message = "Horsepower must be positive")
    private Integer horsePower;

    @NotBlank(message = "Fuel type cannot be blank")
    private String fuelType;

    @NotBlank(message = "Transmission cannot be blank")
    private String transmission;

    @NotBlank(message = "Location cannot be blank")
    private String location;

    @Positive(message = "Mileage must be positive")
    private Integer mileage;

    @NotBlank(message = "Seller type cannot be blank")
    private String sellerType;

    @NotBlank(message = "Door count cannot be blank")
    private String doorCount;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    @NotBlank(message = "Euro category cannot be blank")
    private String euroCategory;

    @NotBlank(message = "Contact number cannot be blank")
    private String contactNumber;

    private Set<CarOptionDTO> carOptions;

    @NotBlank(message = "Steering wheel position cannot be blank")
    private String steeringWheelPosition;


}
