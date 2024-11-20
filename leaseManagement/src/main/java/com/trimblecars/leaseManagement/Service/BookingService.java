package com.trimblecars.leaseManagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimblecars.leaseManagement.entity.BookingEntity;
import com.trimblecars.leaseManagement.entity.CarEntity;
import com.trimblecars.leaseManagement.entity.UserManagementEntity;
import com.trimblecars.leaseManagement.repository.BookingRepository;
import com.trimblecars.leaseManagement.repository.CarRepository;
import com.trimblecars.leaseManagement.repository.UserRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private UserRepository userRepository;


	public ResponseEntity<String> getBooking(BookingEntity bookingEntity) {

		System.err.println(bookingEntity.getUserId().getUserId());

		// get booked user count from table based on user_id
		Integer bookedCarsCount = bookingRepository.countBookedCarsByUser(bookingEntity.getUserId().getUserId());
		System.err.println(bookedCarsCount);

		String userRole = userRepository.getRoleByUserId(bookingEntity.getUserId().getUserId());
		
		  log.debug(" role of the User : *{}*",userRole);
		
		 log.debug("user boolean {}",bookedCarsCount <= 2 && userRole.equalsIgnoreCase("user"));
		if (bookedCarsCount <= 2 && userRole.equalsIgnoreCase("user") ) {
			
			log.debug("VAlidate boolean {}",validateBooking(bookingEntity.getCarsId().getCarID(),
					bookingEntity.getLeaseStartDate().toLocalDate(),
					bookingEntity.getLeaseEndDate().toLocalDate()));
			if(!validateBooking(bookingEntity.getCarsId().getCarID(),
					bookingEntity.getLeaseStartDate().toLocalDate(),
					bookingEntity.getLeaseEndDate().toLocalDate())) {
				
				bookingEntity.setBookingDate(getTodayDate()); //for setting the booking date is today local date
				
				CarEntity carStatus = carRepository.findById(bookingEntity.getCarsId().getCarID()).orElseThrow(() -> new RuntimeException("car not found"));
				carStatus.setCarStatus("booked");  //two lines for setting the car status as booked
				
				carRepository.save(carStatus);
				
				bookingRepository.save(bookingEntity);
				
				
				return ResponseEntity.accepted().body("date are valid");
			}
			 
//			 List<CarEntity> carList=  carRepository.findAll().stream().filter(e->e.getCarStatus().equalsIgnoreCase("active")).toList();
			 } else
				 return ResponseEntity.badRequest().body("car not found");
			
		return new ResponseEntity<String>("maximum booking reached ",HttpStatus.BAD_REQUEST);

	}

	
	
	//to get car by after date is available
	public List<CarEntity> getCarByDate(BookingEntity bookingEntity) {
		List<CarEntity> carList = carRepository.findAvailableCars(bookingEntity.getLeaseStartDate().toLocalDate(),bookingEntity.getLeaseEndDate().toLocalDate());
		return carList;	
		}

	
	
	
	
	
	
	
	
	
	
	
	
	


	// getting Local date Formatted version
	public static LocalDate getTodayDate() { LocalDate today = LocalDate.now();
	DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	dateformatter.format(today);
	return today;
	}
	

	// validate the give dates are not taken 
	public  boolean validateBooking(Integer carId, LocalDate startDate, LocalDate endDate) {
		return bookingRepository.isCarAlreadyBooked(carId, startDate, endDate);
	}

	// validate booking start Date
	public static Boolean validateStartDate(BookingEntity booking) { return booking.getLeaseStartDate().toLocalDate().isBefore(getTodayDate().plusDays(1)) ? false : true; }

	// validate booking end Date
	public static Boolean validateEndDate(BookingEntity booking) { return booking.getLeaseEndDate().toLocalDate().isBefore(booking.getLeaseStartDate().toLocalDate().plusDays(1))? false: true;}




}

//		System.err.println(leaseEndDate.toString());
//		LocalDate leaseEndDate = booking.getLeaseEndDate().toLocalDate();