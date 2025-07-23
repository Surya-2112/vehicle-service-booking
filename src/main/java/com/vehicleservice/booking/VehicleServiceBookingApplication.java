package com.vehicleservice.booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vehicleservice.booking.model.User;
import com.vehicleservice.booking.model.Vehicle;
import com.vehicleservice.booking.repository.UserRepository;
import com.vehicleservice.booking.repository.VehicleRepository;

@SpringBootApplication
public class VehicleServiceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceBookingApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(UserRepository userRepository,VehicleRepository vehicleRepository) {
		return args-> {
			if(userRepository.findByEmail("text@example.com")==null)
			{
				User user=new User("test","text@example.com","test123");
				userRepository.save(user);
				System.out.println(" Test user inserted successfully.");
			}else {
				System.out.println("Test user already exists.");
			}
			if(vehicleRepository.findByRegistrationNumber("TN01AB1234")==null)
			{   Vehicle vehicle=new Vehicle("Hyundai", "i20", "TN01AB1234", "test@example.com");
				vehicleRepository.save(vehicle);
				System.out.println(" Test Vehicle inserted successfully.");
			}else {
				System.out.println("Test Vehicle already exists.");
			}
	};
}
}
