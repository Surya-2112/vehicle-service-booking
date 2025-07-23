package com.vehicleservice.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicleservice.booking.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByEmail(String email);
}
