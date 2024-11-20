package com.trimblecars.leaseManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/car")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping(path = "/saveCar")
	public ResponseEntity<String> addCarDetail(@RequestBody CarEntity car) {

		log.info("Create a car entity : {}", car.toString());
		log.debug("Check the User Id is owner or not "
				+ "if the user Id is not owner the Add car is throw exception : {} ", car.getOwnerID());
		return carService.saveCar(car);
	}

	@GetMapping(path = "/getCar/{carId}")
	public ResponseEntity<?> getCarDetails(@PathVariable Integer carId) {
		log.debug("find car By Id Owner Id : {}", carId);
		return carService.getCarsByOwnerId(carId);
	}

	@PutMapping(path = "/editCar")
	public ResponseEntity<CarEntity> updateCarDetails(@RequestBody CarEntity car, @PathVariable Integer carId) {
		log.trace("Entered in Update Car details using Car Id :{} ", carId);

		if (carId != 0) {
			log.debug("check the car is Valid :{}, carEntity", carId, car);
			ResponseEntity<CarEntity> updatedCar = carService.updateCarDetails(car, carId);
			return new ResponseEntity<CarEntity>(car, HttpStatus.ACCEPTED);

		} else {
			log.error("give proper CarId: { }", carId);
			return ResponseEntity.badRequest().body(car);
		}

	}

}
