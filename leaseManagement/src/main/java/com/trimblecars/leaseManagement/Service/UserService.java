package com.trimblecars.leaseManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// save User Details
	public ResponseEntity<String> saveUser(UserManagementEntity user) {

		userRepo.save(user);
		System.out.println();

		return new ResponseEntity<String>("it's Credated ", HttpStatus.CREATED);

	}

	// getAllUser
	public ResponseEntity<List<UserManagementEntity>> getAllUsers() {
		// TODO Auto-generated method stub

		return ResponseEntity.ok(userRepo.findAll());
	}

	// To Get User by it role in this call Admin should pass the user_id then
	// only it's will give date or else it will not response
	public ResponseEntity<UserManagementEntity> getUserByRole(String userId, String adminId) {
		// TODO Auto-generated method stub

		Optional<UserManagementEntity> verifyRole = userRepo.findById(Integer.parseInt(adminId)).stream()
				.filter(e -> e.getUserRole().equals("admin")).findFirst();
		System.err.println(verifyRole.isPresent());

		if (verifyRole.isPresent())
			return ResponseEntity.ok(userRepo.findById(Integer.parseInt(userId)).orElse(null));
		/*
		 * return new ResponseEntity <UserManagementEntity>
		 * (userRepo.findById(Integer.parseInt(userId)),HttpStatus.ACCEPTED);
		 */
		else
			return new ResponseEntity<UserManagementEntity>(HttpStatus.NOT_ACCEPTABLE);

	}

	// for updating the users details for admin user.
	public ResponseEntity<String> updateUserById(UserManagementEntity user, Integer userId) {
		// TODO Auto-generated method stub

		Optional<UserManagementEntity> oldUser = userRepo.findById(userId);
		if (oldUser.isPresent() && oldUser.get().getUserRole().equals("admin")) {

			oldUser.get().setUserCity(user.getUserCity());
			oldUser.get().setUserContactNumber(user.getUserContactNumber());
			oldUser.get().setUserEmailId(user.getUserEmailId());
			oldUser.get().setUserName(user.getUserName());
			oldUser.get().setUserRole(user.getUserRole());

			userRepo.save(oldUser);
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>("Id or Role is mismatch", HttpStatus.valueOf(" id or role mismatch"));

	}

}
