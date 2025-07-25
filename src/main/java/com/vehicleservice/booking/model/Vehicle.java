package com.vehicleservice.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="Brand is required")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$", message = "Invalid vehicle number format")
	private String brand;
	
	@NotBlank(message="Model is required")
	private String model;
	
	@NotBlank(message="Registration Number  is required")
	@Column(name = "registration_number", unique = true, nullable = false)
	private String registrationNumber;
	
	@Email(message="Owner email must be valid")
	@NotBlank(message="Email  is required")
	private String ownerEmail;
	
	@NotBlank(message = "Vehicle type is required")
    private String vehicleType;
	
	Vehicle(){}
	public Vehicle(String vehicleType,String brand,String model,String registrationNumber,String ownerEmail)
	{   this.vehicleType=vehicleType;
		this.brand=brand;
		this.model=model;
		this.registrationNumber=registrationNumber;
		this.ownerEmail=ownerEmail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}