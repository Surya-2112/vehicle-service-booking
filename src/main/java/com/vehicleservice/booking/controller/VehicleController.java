package com.vehicleservice.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicleservice.booking.exception.DuplicateResourceException;
import com.vehicleservice.booking.exception.ResourceNotFoundException;
import com.vehicleservice.booking.model.Vehicle;
import com.vehicleservice.booking.service.VehicleService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/add")
	public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle)
	{   
		Vehicle exitingVehicle=vehicleService.getVehiclesByRegistrationNumber(vehicle.getRegistrationNumber());
		if(exitingVehicle!=null)
		{
			throw new DuplicateResourceException("Vehicle with registration number "+vehicle.getRegistrationNumber()+"already exits");
		}
		Vehicle savedVehicle=vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<>(savedVehicle,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Vehicle> getAllVehicles()
	{
		return vehicleService.getAllVehicles();
	}
	
	@GetMapping("/{registrationNumber}")
	public ResponseEntity<Vehicle> getByRegistrationNumber(@PathVariable String registrationNumber)
	{	
		Vehicle exitingVehicle=vehicleService.getVehiclesByRegistrationNumber(registrationNumber);
		if(exitingVehicle==null)
		{
			throw new ResourceNotFoundException("Vehicle with registration Number "+registrationNumber+" not found.");
		}
		return new ResponseEntity<>(exitingVehicle,HttpStatus.OK);
	}
}
