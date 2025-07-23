package com.vehicleservice.booking.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex)
	{
		Map<String,Object> error=new HashMap<>();
		error.put("timestamp",LocalDateTime.now());
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenricException(Exception ex)
	{
		Map<String,Object> error=new HashMap<>();
		error.put("timestamp",LocalDateTime.now());
		error.put("message", "Internal Server Error");
		error.put("details",ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
