package com.vehicleservice.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicleservice.booking.model.User;
import com.vehicleservice.booking.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@Valid @RequestBody User user)
	{
		return userService.registeruser(user);
	}
	
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable String email)
	{
		return userService.getUserByEmail(email);
	}
}
