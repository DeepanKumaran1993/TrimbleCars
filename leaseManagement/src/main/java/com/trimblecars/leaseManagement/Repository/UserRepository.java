package com.trimblecars.leaseManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.entity.UserManagementEntity;
@Repository
public interface UserRepository extends JpaRepository<UserManagementEntity, Integer> {

	Optional<UserManagementEntity> findById(Integer userId);

	void save(Optional<UserManagementEntity> oldUser);
	
	@Query("select b.userRole From UserManagementEntity b Where b.userId = :userID")
	String getRoleByUserId (@Param ("userID") Integer UserId );

	
}
