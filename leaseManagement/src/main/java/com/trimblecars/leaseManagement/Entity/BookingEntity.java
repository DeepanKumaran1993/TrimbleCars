package com.trimblecars.leaseManagement.Entity;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trimblecars.leaseManagement.deserializer.CarEntityDeserializer;
import com.trimblecars.leaseManagement.deserializer.UserManagementEntityDeserializer;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookingEntity {

//	user_id *
//	lease_start_date
//	lease_end_date
//	booking_date
//	car_id
//	booking_id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingID;

	@Column(name = "lease_start_date")
	private Date leaseStartDate;

	@Column(name = "lease_end_date")
	private Date leaseEndDate;

	@Column(name = "booking_date")
	private Date bookingDate;

	@Nullable
	@Column(name = "booking_status")
	private String bookingStatus;

	// @MapsId
	// @OneToOne
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonDeserialize(using = UserManagementEntityDeserializer.class)
	private UserManagementEntity userId;

//	@MapsId
	// @OneToOne
	
	@ManyToOne
	@JoinColumn(name = "car_id", referencedColumnName = "car_id" )
	@JsonDeserialize(using=CarEntityDeserializer.class)
	private CarEntity carsId;

	public BookingEntity() {
		super();
	}

	public BookingEntity(Integer bookingID, Date leaseStartDate, Date leaseEndDate, Date bookingDate,
			String bookingStatus, UserManagementEntity userId,
			 CarEntity carsId) {
		super();
		this.bookingID = bookingID;
		this.leaseStartDate = leaseStartDate;
		this.leaseEndDate = leaseEndDate;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.userId = userId;
		this.carsId = carsId;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public UserManagementEntity getUserId() {
		return userId;
	}

	public void setUserId(UserManagementEntity userId) {
		this.userId = userId;
	}

	public CarEntity getCarsId() {
		return carsId;
	}

	public void setCarsId(CarEntity carsId) {
		this.carsId = carsId;
	}

	@Override
	public String toString() {
		return "BookingEntity [bookingID=" + bookingID + ", leaseStartDate=" + leaseStartDate + ", leaseEndDate="
				+ leaseEndDate + ", bookingDate=" + bookingDate + ", bookingStatus=" + bookingStatus + ", userId="
				+ userId + ", carsId=" + carsId + "]";
	}

}
