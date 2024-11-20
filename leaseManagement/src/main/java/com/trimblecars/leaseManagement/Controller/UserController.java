package com.trimblecars.leaseManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.entity.UserManagementEntity;
import com.trimblecars.leaseManagement.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	
    //save userAPI for admin to save the users	
	@PostMapping(path="/saveuser")
	public ResponseEntity<String> saveUser(@RequestBody UserManagementEntity request) {
		log.trace("Entered to  save User in UserController {}",request.toString());
		return  userService.saveUser(request);
	}
	
    //get all Users for admin purpose
	@GetMapping(path="/getuser")
	public ResponseEntity<List<UserManagementEntity>> getAllUser(){
		log.info("Entered in getAllUSer API");
		return userService.getAllUsers();
	}
	
	
    // check the user Role for admin purpose 	
	@GetMapping(path="/userrole/{userId}")
    public ResponseEntity<UserManagementEntity> getUserRole(@PathVariable("userId") String userId,@RequestParam("adminId") String adminId ){
		log.debug("for getting userById userid:{},adminId :{}   "+adminId);
		System.err.println(userId+"   "+ adminId);
    	return userService.getUserByRole(userId, adminId);
    }
	

    //edit user role and status for admin uses 
	@PutMapping(path="/edituser/{userId}")
	public ResponseEntity<String> editUserDetails
	(@PathVariable Integer userId ,@RequestBody UserManagementEntity user)
	{
		return userService.updateUserById(user,userId);
	
	}
	
	
	
	

}
