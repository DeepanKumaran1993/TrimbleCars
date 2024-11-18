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
import com.trimblecars.leaseManagement.deserializer.*;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
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


@OneToOne
//@MapsId
@JoinColumn(name="user_id")
@JsonDeserialize(using = UserManagementEntityDeserializer.class)
private UserManagementEntity ownerID;

@Column(name="created_date")
private LocalDate createdDate;

@Column(name="car_last_modified")
private LocalDate lastModifiedDate;

public Integer getCarID() {
	return carID;
}

public void setCarID(Integer carID) {
	this.carID = carID;
}

public String getCarType() {
	return carType;
}

public void setCarType(String carType) {
	this.carType = carType;
}

public String getCarModel() {
	return carModel;
}

public void setCarModel(String carModel) {
	this.carModel = carModel;
}

public String getCarMake() {
	return carMake;
}

public void setCarMake(String carMake) {
	this.carMake = carMake;
}

public String getCarTransMissionType() {
	return carTransMissionType;
}

public void setCarTransMissionType(String carTransMissionType) {
	this.carTransMissionType = carTransMissionType;
}

public String getCarStatus() {
	return carStatus;
}

public void setCarStatus(String carStatus) {
	this.carStatus = carStatus;
}

public String getCarFuelType() {
	return carFuelType;
}

public void setCarFuelType(String carFuelType) {
	this.carFuelType = carFuelType;
}

public String getCarVinNumber() {
	return carVinNumber;
}

public void setCarVinNumber(String carVinNumber) {
	this.carVinNumber = carVinNumber;
}

public UserManagementEntity getOwnerID() {
	return ownerID;
}

public void setOwnerID(UserManagementEntity ownerID) {
	this.ownerID = ownerID;
}

public LocalDate getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}

public LocalDate getLastModifiedDate() {
	return lastModifiedDate;
}

public void setLastModifiedDate(LocalDate lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}

@Override
public String toString() {
	return "CarEntity [carID=" + carID + ", carType=" + carType + ", carModel=" + carModel + ", carMake=" + carMake
			+ ", carTransMissionType=" + carTransMissionType + ", carStatus=" + carStatus + ", carFuelType="
			+ carFuelType + ", carVinNumber=" + carVinNumber + ", ownerID=" + ownerID + ", createdDate=" + createdDate
			+ ", lastModifiedDate=" + lastModifiedDate + "]";
}

public CarEntity(Integer carID, String carType, String carModel, String carMake, String carTransMissionType,
		String carStatus, String carFuelType, String carVinNumber, UserManagementEntity ownerID, LocalDate createdDate,
		LocalDate lastModifiedDate) {
	super();
	this.carID = carID;
	this.carType = carType;
	this.carModel = carModel;
	this.carMake = carMake;
	this.carTransMissionType = carTransMissionType;
	this.carStatus = carStatus;
	this.carFuelType = carFuelType;
	this.carVinNumber = carVinNumber;
	this.ownerID = ownerID;
	this.createdDate = createdDate;
	this.lastModifiedDate = lastModifiedDate;
}

public CarEntity() {
	super();
}



}
