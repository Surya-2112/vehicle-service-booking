package com.vehicleservice.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleservice.booking.exception.DuplicateResourceException;
import com.vehicleservice.booking.exception.ResourceNotFoundException;
import com.vehicleservice.booking.model.Vehicle;
import com.vehicleservice.booking.repository.VehicleRepository;

import jakarta.validation.Valid;
@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle saveVehicle(@Valid Vehicle vehicle)
	{    Vehicle exitingVehicle = vehicleRepository.findByRegistrationNumber(vehicle.getRegistrationNumber());
		if(exitingVehicle!=null)
		{
			throw new DuplicateResourceException("Vehicle with registration Number"+vehicle.getRegistrationNumber()+"already exits");
		}
		return vehicleRepository.save(vehicle);
	}
	
	public List<Vehicle> getAllVehicles()
	{
		return vehicleRepository.findAll();
	}
	
	public Vehicle getVehiclesByRegistrationNumber(String registrationNumber)
	{    Vehicle exitingVehicle=vehicleRepository.findByRegistrationNumber(registrationNumber);
			if(exitingVehicle==null)
			{
				throw new ResourceNotFoundException("Vehicle with Registration number"+registrationNumber+"not found.");
			}
		return exitingVehicle;
	}


}
