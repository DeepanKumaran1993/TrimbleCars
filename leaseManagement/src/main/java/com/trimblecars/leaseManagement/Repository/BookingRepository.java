package com.trimblecars.leaseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.Entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{
	
	

}
