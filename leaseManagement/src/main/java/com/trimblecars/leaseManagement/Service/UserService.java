package com.trimblecars.leaseManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepo;
	
	public ResponseEntity<String> saveUser(UserManagementEntity user) {
		
		userRepo.save(user);
		System.out.println();
		
		return new ResponseEntity<String> ("it's Credated ",HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<UserManagementEntity>> getAllUsers() {
		// TODO Auto-generated method stub
		
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	
}
