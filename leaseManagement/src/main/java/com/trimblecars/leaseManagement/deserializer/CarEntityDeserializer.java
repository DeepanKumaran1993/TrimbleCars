package com.trimblecars.leaseManagement.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
import com.trimblecars.leaseManagement.Repository.CarRepository;
import com.trimblecars.leaseManagement.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CarEntityDeserializer extends JsonDeserializer<CarEntity> {

    @Autowired
    private CarRepository carRepository;
    // Your repository to fetch UserManagementEntity by ID

    @Override
    public CarEntity deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        Integer userId =  jsonParser.getIntValue();
        		//.getLongValue(); // Extract user ID from JSON
        return carRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
