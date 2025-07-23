package com.vehicleservice.booking.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
