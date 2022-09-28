package com.exam.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.PosUser;

@Repository
public interface PosUserRepository extends JpaRepository<PosUser, Long> {
	
	public PosUser findByUserEmailAndUserPassword(String email, String password);

	
}
