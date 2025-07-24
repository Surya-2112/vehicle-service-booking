package com.vehicleservice.booking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Booking Date and Time is requierd")
	@Future(message="Booking date and time in Future")
	private LocalDateTime localdateTime;
	
	@NotBlank(message="ServiceType is required")
	private String serviceType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	Booking(){};
	
	Booking(LocalDateTime localDateTime,String serviceType,User user,Vehicle vehicle){
		this.localdateTime=localDateTime;
		this.serviceType=serviceType;
		this.user=user;
		this.vehicle=vehicle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getLocaldateTime() {
		return localdateTime;
	}

	public void setLocaldateTime(LocalDateTime localdateTime) {
		this.localdateTime = localdateTime;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
