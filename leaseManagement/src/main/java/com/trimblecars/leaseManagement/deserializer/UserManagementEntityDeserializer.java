package com.trimblecars.leaseManagement.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.trimblecars.leaseManagement.entity.UserManagementEntity;
import com.trimblecars.leaseManagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserManagementEntityDeserializer extends JsonDeserializer<UserManagementEntity> {

	@Autowired
	private UserRepository userRepository;
	// Your repository to fetch UserManagementEntity by ID

	@Override
	public UserManagementEntity deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
		Integer userId = jsonParser.getIntValue();
		// .getLongValue(); // Extract user ID from JSON
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}
}
