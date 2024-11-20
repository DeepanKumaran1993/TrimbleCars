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
@Slf4j
public class CarService {

	@Autowired
	CarRepository carRepository;

//	@Autowired
//	CarEntity carEntity;
// save the car 
	public ResponseEntity<String> saveCar(CarEntity car) {

		log.debug("To save car Entity");
		carRepository.save(car);
		return new ResponseEntity<String>("car Created ", HttpStatus.OK);
	}

// get the car by it's owner det
	public ResponseEntity<?> getCarsByOwnerId(Integer ownerId) {
		log.trace("Checking and get Car Detail for Car Repository");
		List<CarEntity> carList = carRepository.findByOwnerId(ownerId);

		if (carList.isEmpty()) {
			log.error("car Not Found based in Owner ID");
			return ResponseEntity.badRequest().body("Car not found");
		} else {
			log.info("Car Found");
			return ResponseEntity.ok(carList.listIterator());
		}

	}

	public ResponseEntity<CarEntity> updateCarDetails(CarEntity car, Integer carId) {
		log.trace(" In updateCarDetails to check's car is found based in carID ");
		Optional<CarEntity> oldCarEntity = carRepository.findById(carId);
		if (oldCarEntity.isPresent()) {
			log.info("car is found setting new car attributes to old car Entity ");
			CarEntity oldCar = oldCarEntity.get();
			oldCar.setCarFuelType(car.getCarFuelType());
			oldCar.setCarMake(car.getCarMake());
			oldCar.setCarModel(car.getCarModel());
			oldCar.setCarTransMissionType(car.getCarTransMissionType());
			oldCar.setCarType(car.getCarType());
			oldCar.setCarVinNumber(car.getCarVinNumber());
			return new ResponseEntity<CarEntity>(carRepository.save(oldCar), HttpStatus.ACCEPTED);
		} else {
			log.error("Car Not Found");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
