package com.bezbrakmi.app;

import com.bezbrakmi.app.entity.CarListing;
import com.bezbrakmi.app.entity.CarOption;
import com.bezbrakmi.app.model.BodyType;
import com.bezbrakmi.app.model.CarBrand;
import com.bezbrakmi.app.model.OptionCategory;
import com.bezbrakmi.app.repository.CarListingRepository;
import com.bezbrakmi.app.service.CarListingService;
import com.bezbrakmi.app.service.CarListingServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BezBrakmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BezBrakmiApplication.class, args);
	}

}
