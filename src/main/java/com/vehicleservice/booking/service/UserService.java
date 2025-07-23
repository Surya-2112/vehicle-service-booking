package com.vehicleservice.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleservice.booking.model.User;
import com.vehicleservice.booking.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User registeruser(User user)
	{
		return userRepository.save(user);
	}
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	public User getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
}
