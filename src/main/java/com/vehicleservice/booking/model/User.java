package com.vehicleservice.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message =" Name is Required")
	private String name;
	 
	@Email(message = "Invalid email format")
	 @NotBlank(message = "Email is required")
	 private String email;
	 
	
	@Pattern(
		    regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
		    message = "Password must be at least 8 characters and include an lowerCase letter, a number, and a special character"
		)
	private String password;
	
	@NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid contact number")
    private String contactNumber;

	User(){}
	
	public User(String name,String email,String password,String contactNumber)
	{
		this.name=name;
		this.email=email;
		this.password=password;
		this.contactNumber=contactNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
