package com.vehicleservice.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleservice.booking.model.Booking;
import com.vehicleservice.booking.model.User;
import com.vehicleservice.booking.model.Vehicle;
import com.vehicleservice.booking.repository.BookingRepository;
import com.vehicleservice.booking.repository.UserRepository;
import com.vehicleservice.booking.repository.VehicleRepository;
@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	public Booking saveBooking(Booking booking)
	{    
		Long userId=booking.getUser().getId();
		
		User user=userRepository.findById(userId)
				.orElseThrow (()->new RuntimeException("User not found with id"+userId));
		
		Long vehicleId = booking.getVehicle().getId();
		
		Vehicle vehicle=vehicleRepository.findById(vehicleId)
				.orElseThrow (()->new RuntimeException("Vehicle not found with id"+vehicleId));
		
		booking.setUser(user);
		booking.setVehicle(vehicle);
		
		return bookingRepository.save(booking);
	}
	
	public List<Booking> getAllBookings()
	{
		return bookingRepository.findAll();
	}
	
	public Booking getBookingById(long id)
	{
		return bookingRepository.findById(id)
				.orElseThrow( ()->new RuntimeException("Booking not found with id"+id) );
	}
}
