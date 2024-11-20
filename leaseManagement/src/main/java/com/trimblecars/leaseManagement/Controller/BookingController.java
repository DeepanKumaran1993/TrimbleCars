package com.trimblecars.leaseManagement.controller;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.entity.BookingEntity;
import com.trimblecars.leaseManagement.entity.CarEntity;
import com.trimblecars.leaseManagement.service.BookingService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(path = "/getbooking")
	public ResponseEntity<String> addBooking(@RequestBody BookingEntity bookingEntity) {
		log.info("Create a Booking");

		if (BookingService.validateStartDate(bookingEntity) && BookingService.validateEndDate(bookingEntity)) {
			log.debug("validate the user Booking date in controller for the date before booking. in controller" + " ",
					BookingService.validateStartDate(bookingEntity) && bookingService.validateEndDate(bookingEntity));
			return bookingService.getBooking(bookingEntity);
		} else
			return ResponseEntity.badRequest().body("date are invalid");
	}

	// this call for getting avaliable car from DateBase
	@PostMapping("/getcars")
	public ResponseEntity<List<CarEntity>> getAvailableCarList(@RequestBody BookingEntity bookingEntity) {
	log.info("Car list from exact booking date with user startDate : {} , EndDate :{} "
			,bookingEntity.getLeaseStartDate());
		
		return new ResponseEntity<List<CarEntity>>(bookingService.getCarByDate(bookingEntity), HttpStatus.OK);
	}

}
