package com.trimblecars.leaseManagement.Controller;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Service.BookingService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(path="/booking")
public class BookingController {


	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping(path="/getBooking")
	public ResponseEntity<String> addBooking(@RequestBody BookingEntity bookingEntity)
	{
		if(BookingService.validateStartDate(bookingEntity)&&bookingService.validateEndDate(bookingEntity))
			return bookingService.getBooking(bookingEntity);
		else
			return ResponseEntity.badRequest().body("date are invalid");	
	}
	
	
	
	//this call for getting avaliable car from DateBase
	@PostMapping("/getCars")
	public ResponseEntity<List<CarEntity>> getAvailableCarList(@RequestBody BookingEntity bookingEntity){
	
		return new ResponseEntity<List< CarEntity>>(bookingService.getCarByDate( bookingEntity),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
