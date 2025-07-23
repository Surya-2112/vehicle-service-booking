package com.vehicleservice.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleservice.booking.model.Vehicle;
import com.vehicleservice.booking.repository.VehicleRepository;
@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle addVehicle(Vehicle vehicle)
	{
		return vehicleRepository.save(vehicle);
	}
	
	public List<Vehicle> getAllVehicles()
	{
		return vehicleRepository.findAll();
	}
	
	public Vehicle getVehiclesByRegistrationNumber(String registrationNumber)
	{
		return vehicleRepository.findByRegistrationNumber(registrationNumber);
	}
}
