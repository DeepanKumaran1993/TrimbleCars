package com.trimblecars.leaseManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimblecars.leaseManagement.Entity.CarEntity;
import com.trimblecars.leaseManagement.Entity.UserManagementEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

	Optional<CarEntity> findById(Integer userId);

}
