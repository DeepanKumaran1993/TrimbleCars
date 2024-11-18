package com.trimblecars.leaseManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{

	

	@Query("SELECT COUNT(b) FROM BookingEntity b WHERE b.userId = :userId AND b.bookingStatus = 'booked'")
	Integer countBookedCarsByUser(@Param("userId") Integer l);
	

}
