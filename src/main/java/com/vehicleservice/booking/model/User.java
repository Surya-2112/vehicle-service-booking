package com.vehicleservice.booking.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
	 
	
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
	User(){}
	
	public User(String name,String email,String password)
	{
		this.name=name;
		this.email=email;
		this.password=password;
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
	
}
