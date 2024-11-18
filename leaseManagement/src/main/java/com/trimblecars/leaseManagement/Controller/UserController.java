package com.trimblecars.leaseManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path="/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserManagementEntity request) {

		System.err.println(request.getUserCity());
		return  userService.saveUser(request);
	}
	
	
	
	@GetMapping(path="/getUser")
	public ResponseEntity<List<UserManagementEntity>> getAllUser(){
		
		return userService.getAllUsers();
	}

}
