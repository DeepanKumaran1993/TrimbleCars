package com.trimblecars.leaseManagement.entity;

import java.sql.Date;
import java.time.LocalDate;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {

	/*
	 * // user_id * // lease_start_date // lease_end_date // booking_date // car_id
	 * // booking_id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingID;

	@Column(name = "lease_start_date")
	private Date leaseStartDate;

	@Column(name = "lease_end_date")
	private Date leaseEndDate;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

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
	@JoinColumn(name = "car_id", referencedColumnName = "car_id")
	@JsonDeserialize(using = CarEntityDeserializer.class)
	private CarEntity carsId;



}
