package com.vehicleservice.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicleservice.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {
	List<Booking> findByUserId(Long userId);
}
