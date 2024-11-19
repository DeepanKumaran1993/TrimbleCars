package com.trimblecars.leaseManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Repository.CarRepository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Log4j2
@Slf4j
public class CarService {

	@Autowired
	CarRepository carRepository;
	

//	@Autowired
//	CarEntity carEntity;
// save the car 
	public ResponseEntity<String> saveCar(CarEntity car) {
		
		carRepository.save(car);
		return new ResponseEntity<String>("car Created ", HttpStatus.OK);
	}

// get the car by it's owner det
	public ResponseEntity<?> getCarsByOwnerId(Integer ownerId) {
	
		List<CarEntity> carList = carRepository.findByOwnerId(ownerId);

		if (carList.isEmpty())
			return ResponseEntity.badRequest().body("Car not found");
		else
			return ResponseEntity.ok(carList.listIterator());

	}
	
	
	

}
