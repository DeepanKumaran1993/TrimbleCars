package com.trimblecars.leaseManagement.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{

	

	//@Query("SELECT COUNT(b) FROM BookingEntity b WHERE b.userId = ?userId AND b.bookingStatus = 'booked'")
//	
//	@Query(value = "SELECT COUNT(b.userId) FROM BookingEntity b WHERE b.userId = ?1 AND b.bookingStatus ='booked'")
//	Integer countBookedCarsByUser(@Param("userId") Integer userId);
//	
	@Query("SELECT COUNT(b) FROM BookingEntity b WHERE b.userId.userId = :userId AND b.bookingStatus = 'booked'")
    Integer countBookedCarsByUser(@Param("userId") Integer userId);
	
	
	@Query("SELECT COUNT(b) > 0 FROM BookingEntity b " +
		       "WHERE b.carsId.carID = :carId " +
		       "AND b.bookingStatus = 'booked' " +
		       "AND ((:startDate BETWEEN b.leaseStartDate AND b.leaseEndDate) " +
		       "OR (:endDate BETWEEN b.leaseStartDate AND b.leaseEndDate) " +
		       "OR (b.leaseStartDate BETWEEN :startDate AND :endDate))")
		boolean isCarAlreadyBooked(@Param("carId") Integer carId,
		                           @Param("startDate") LocalDate startDate,
		                           @Param("endDate") LocalDate endDate);
	
	
	
	

	

}
