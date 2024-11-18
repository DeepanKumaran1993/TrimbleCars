package com.trimblecars.leaseManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
import com.trimblecars.leaseManagement.Service.BookingService;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping(path="/getBooking")
	public ResponseEntity<String> addBooking(@RequestBody BookingEntity bookingEntity)
	{
		
		
		
		return bookingService.getBooking(bookingEntity);
	}
	
	
	
	
	
	
	
	
	
	
}
