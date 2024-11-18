package com.trimblecars.leaseManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.Entity.UserManagementEntity;
@Repository
public interface UserRepository extends JpaRepository<UserManagementEntity, Integer> {

	Optional<UserManagementEntity> findById(Integer userId);

	
}
