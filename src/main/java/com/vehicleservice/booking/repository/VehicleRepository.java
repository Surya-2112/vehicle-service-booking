package com.vehicleservice.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicleservice.booking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long > {
	Vehicle findByRegistrationNumber(String registrationNumber);
}
