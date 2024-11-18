package com.trimblecars.leaseManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
import com.trimblecars.leaseManagement.Repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	public ResponseEntity<String> getBooking(BookingEntity bookingEntity){
		
		bookingRepo.save(bookingEntity);
		
		return new ResponseEntity<String>("car Booked",HttpStatus.OK);
	}
	
}

