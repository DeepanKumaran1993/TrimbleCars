package com.trimblecars.leaseManagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.entity.CarEntity;
import com.trimblecars.leaseManagement.entity.UserManagementEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

	Optional<CarEntity> findById(Integer userId);

	@Query("SELECT c FROM CarEntity c " + "WHERE c.carID NOT IN (" + "SELECT b.carsId.carID FROM BookingEntity b "
			+ "WHERE b.bookingStatus = 'booked' " + "AND ((:startDate BETWEEN b.leaseStartDate AND b.leaseEndDate) "
			+ "OR (:endDate BETWEEN b.leaseStartDate AND b.leaseEndDate) "
			+ "OR (b.leaseStartDate BETWEEN :startDate AND :endDate))" + ")")
	List<CarEntity> findAvailableCars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);



	
	@Query("SELECT c FROM CarEntity c WHERE c.ownerID.userId = :ownerID")
    List<CarEntity> findByOwnerId(@Param("ownerID") Integer ownerID);

}
