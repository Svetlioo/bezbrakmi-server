package com.bezbrakmi.app.converter;

import com.bezbrakmi.app.dto.CarListingDTO;
import com.bezbrakmi.app.dto.CarOptionDTO;
import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.entity.CarOption;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CarListingConverter {

    public static CarListing convertToEntity(CarListingDTO carListingDTO) {
        return CarListing.builder()
                .brand(carListingDTO.getBrand())
                .model(carListingDTO.getModel())
                .description(carListingDTO.getDescription())
                .bodyType(carListingDTO.getBodyType())
                .price(carListingDTO.getPrice())
                .engine(carListingDTO.getEngine())
                .engineSizeCC(carListingDTO.getEngineSizeCC())
                .condition(carListingDTO.getCondition())
                .year(carListingDTO.getYear())
                .horsePower(carListingDTO.getHorsePower())
                .fuelType(carListingDTO.getFuelType())
                .transmission(carListingDTO.getTransmission())
                .location(carListingDTO.getLocation())
                .mileage(carListingDTO.getMileage())
                .sellerType(carListingDTO.getSellerType())
                .doorCount(carListingDTO.getDoorCount())
                .color(carListingDTO.getColor())
                .euroCategory(carListingDTO.getEuroCategory())
                .contactNumber(carListingDTO.getContactNumber())
                .carOptions(convertCarOptions(carListingDTO.getCarOptions()))
                .steeringWheelPosition(carListingDTO.getSteeringWheelPosition())
                .build();
    }

    private static Set<CarOption> convertCarOptions(Set<CarOptionDTO> carOptionsDTO) {
        Set<CarOption> carOptions = new HashSet<>();
        if (carOptionsDTO != null) {
            for (CarOptionDTO carOptionDTO : carOptionsDTO) {
                CarOption carOption = CarOption.builder()
                        .name(carOptionDTO.getName())
                        .category(carOptionDTO.getCategory())
                        .build();
                carOptions.add(carOption);
            }
        }
        return carOptions;
    }

    public static CarListingDTO convertToDTO(CarListing carListing) {
        return CarListingDTO.builder()
                .brand(carListing.getBrand())
                .model(carListing.getModel())
                .description(carListing.getDescription())
                .bodyType(carListing.getBodyType())
                .price(carListing.getPrice())
                .engine(carListing.getEngine())
                .engineSizeCC(carListing.getEngineSizeCC())
                .condition(carListing.getCondition())
                .year(carListing.getYear())
                .horsePower(carListing.getHorsePower())
                .fuelType(carListing.getFuelType())
                .transmission(carListing.getTransmission())
                .location(carListing.getLocation())
                .mileage(carListing.getMileage())
                .sellerType(carListing.getSellerType())
                .doorCount(carListing.getDoorCount())
                .color(carListing.getColor())
                .euroCategory(carListing.getEuroCategory())
                .contactNumber(carListing.getContactNumber())
                .carOptions(convertCarOptionsDTO(carListing.getCarOptions()))
                .steeringWheelPosition(carListing.getSteeringWheelPosition())
                .build();
    }

    private static Set<CarOptionDTO> convertCarOptionsDTO(Set<CarOption> carOptions) {
        Set<CarOptionDTO> carOptionsDTO = new HashSet<>();
        if (carOptions != null) {
            for (CarOption carOption : carOptions) {
                CarOptionDTO carOptionDTO = CarOptionDTO.builder()
                        .name(carOption.getName())
                        .category(carOption.getCategory())
                        .build();
                carOptionsDTO.add(carOptionDTO);
            }
        }
        return carOptionsDTO;
    }

}