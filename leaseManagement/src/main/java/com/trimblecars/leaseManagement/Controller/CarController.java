package com.trimblecars.leaseManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Service.CarService;

@RestController
@RequestMapping(path = "/car")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping(path = "/saveCar")
	public ResponseEntity<String> addCarDetail(@RequestBody CarEntity car) {

		System.err.println(car.toString());
		return carService.saveCar(car);
	}

	@GetMapping(path = "/getCar/{carId}")
	public ResponseEntity<?> getCarDetails(@PathVariable Integer carId) {
 
		return carService.getCarsByOwnerId(carId);
	}

}
