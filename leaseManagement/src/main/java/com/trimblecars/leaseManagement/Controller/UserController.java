package com.trimblecars.leaseManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;

	
//save userAPI for admin to save the users	
	@PostMapping(path="/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserManagementEntity request) {

		System.err.println(request.getUserCity());
		return  userService.saveUser(request);
	}
	
//get all Users for admin purpose
	@GetMapping(path="/getUser")
	public ResponseEntity<List<UserManagementEntity>> getAllUser(){
		
		return userService.getAllUsers();
	}
	
	
// check the user Role for admin purpose 	
	@GetMapping(path="/userRole/{userId}")
    public ResponseEntity<UserManagementEntity> getUserRole(@PathVariable("userId") String userId,@RequestParam("adminId") String adminId ){
    
		System.err.println(userId+"   "+ adminId);
    	return userService.getUserByRole(userId, adminId);
    }
	

//edit user role and status for admin uses 
	@PatchMapping(path="/editUser/{userId}")
	public ResponseEntity<String> editUserDetails
	(@PathVariable Integer userId ,@RequestBody UserManagementEntity user)
	{
		return userService.updateUserById(user,userId);
	
	}
	
	
	
	

}
