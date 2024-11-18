package com.trimblecars.leaseManagement.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Repository.BookingRepository;
import com.trimblecars.leaseManagement.Repository.CarRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	CarRepository carRepository;

	public ResponseEntity<String> getBooking(BookingEntity bookingEntity) {

		
		System.err.println(bookingEntity.getUserId().getUserId());
		
		 Integer bookedCarsCount = bookingRepo.countBookedCarsByUser(bookingEntity.getUserId().getUserId());

		 System.err.println(bookedCarsCount);
//	        if (bookedCarsCount >= 2) {
//	            throw new RuntimeException("User cannot book more than 2 cars with status 'Booked'.");
//	        }
		
		
		
		if (validateStartDate(bookingEntity) && 
				BookingService.validateEndDate(bookingEntity)) {
			
			  bookingEntity.setBookingDate(getTodayDate());
			  
			  
			  CarEntity carStatus=
					  carRepository.findById(bookingEntity.getCarsId().getCarID())
					  .orElseThrow(()->new RuntimeException("car not found"));
			  
			  carStatus.setCarStatus("booked");
			  
			//  carRepository.save(carStatus);
			  
					  
					  //bookingRepo.save(bookingEntity);
			
			return ResponseEntity.accepted().body("date are valid");
		} else
			return ResponseEntity.badRequest().body("booking date is invalid");
		
	}
	
	
	public static ResponseEntity<BookingEntity > getDetailFromTable(){
		
	 //Optional<BookingEntity> userList=bookingRepo.findByUserId(1);
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getting Local date Formatted version
	public static LocalDate getTodayDate() {

		LocalDate today = LocalDate.now();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dateformatter.format(today);
		// System.err.println(formattedTodayDate);
		return today;
	}

	//validate booking end Date
	public static Boolean validateEndDate(BookingEntity booking) {

		return booking.getLeaseEndDate().toLocalDate().
				isBefore(booking.getLeaseStartDate().toLocalDate().plusDays(1))
				? false: true;

	}
// validate booking start Date
	public static Boolean validateStartDate(BookingEntity booking) {
		
		return booking.getLeaseStartDate().toLocalDate().
				isBefore(getTodayDate().plusDays(1)) ? false : true;
	}

}

//		System.err.println(leaseEndDate.toString());
//		LocalDate leaseEndDate = booking.getLeaseEndDate().toLocalDate();