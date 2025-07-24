package com.vehicleservice.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicleservice.booking.model.Booking;
import com.vehicleservice.booking.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/add")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking)
	{ 
		Booking savedBooking=bookingService.saveBooking(booking);
		return new ResponseEntity<>(savedBooking,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Booking>> getAllBooking()
	{
		List<Booking> bookings= bookingService.getAllBookings();
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getByBookingId(@PathVariable Long id)
	{
		Booking booking= bookingService.getBookingById(id);
		return new ResponseEntity<>(booking,HttpStatus.OK);
	}
}
