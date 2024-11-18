package com.trimblecars.leaseManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepo;
	
	 public ResponseEntity<String> saveCar(CarEntity car){
		 
		 carRepo.save(car);
		 return new ResponseEntity<String> ("car Created ",HttpStatus.OK);
	 }
	
	
	
}
