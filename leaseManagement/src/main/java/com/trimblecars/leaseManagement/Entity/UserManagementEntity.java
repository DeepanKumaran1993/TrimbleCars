package com.trimblecars.leaseManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
@Table(name = "user_management")
@Entity
public class UserManagementEntity {

	/*
	 * // // user_id * // user_name // user_email_id // user_role //
	 * user_contact_number // user_city
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;
//
	@Column(name = "user_email_id")
	private String userEmailId;

	@Column(name = "user_role")
	private String userRole;

	@Column(name = "user_contact_number")
	private long userContactNumber;

	@Column(name = "user_city")
	private String userCity;

}
