package com.trimblecars.leaseManagement.Entity;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import com.trimblecars.leaseManagement.deserializer.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
//@Table(name="car_list")
public class CarEntity {

	
	
//	car_registration_number
//	car_id
//	car_make
//	car_type
//	car_model
//	car_tranmission_type
//	car_status
//	car_fuel_type
//	car_vin_number
//	owner_id *
//	created_date
//	car_last_modified

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="car_id")
private Integer carID;



@Column(name="car_type")
private String carType;

@Column(name="car_model")	
private String carModel;


@Column(name="car_make")
private String carMake;
	


@Column(name="car_tranmission_type")
private String carTransMissionType;

@Column(name="car_status")
private String carStatus;

@Column(name="car_fuel_type")
private String carFuelType;

@Column(name="car_vin_number")
private String carVinNumber;


@NotBlank
@OneToOne
//@MapsId
@JoinColumn(name="user_id")
@JsonDeserialize(using = UserManagementEntityDeserializer.class)
private UserManagementEntity ownerID;

@Column(name="created_date")
private LocalDate createdDate;

@Column(name="car_last_modified")
private LocalDate lastModifiedDate;

}
