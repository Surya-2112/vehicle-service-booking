package com.vehicleservice.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI vehicleServiceOpenAPI()
	{
		return new OpenAPI()
			.info(new Info()
					.title("Vehicle Service Booking System API")
					.description("API documentation for Vehicle Service Booking Application")
                    .version("1.0.0"));
	}
}
