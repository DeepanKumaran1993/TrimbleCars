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

@Entity
@Table(name = "user_management")
public class UserManagementEntity {

	/*
	 * // // user_id * // user_name // user_email_id // user_role //
	 * user_contact_number // user_city
	 */

	public UserManagementEntity(Integer userId, String userName, String userEmailId, String userRole,
			long userContactNumber, String userCity) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.userRole = userRole;
		this.userContactNumber = userContactNumber;
		this.userCity = userCity;
	}

	@Override
	public String toString() {
		return "UserManagementEntity [userId=" + userId + ", userName=" + userName + ", userEmailId=" + userEmailId
				+ ", userRole=" + userRole + ", userContactNumber=" + userContactNumber + ", userCity=" + userCity
				+ "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserManagementEntity() {
		super();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public long getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

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
