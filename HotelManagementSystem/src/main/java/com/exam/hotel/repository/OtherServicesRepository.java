package com.exam.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.OtherServicesRecord;

@Repository
public interface OtherServicesRepository extends JpaRepository<OtherServicesRecord, Long> {
		
	public List<OtherServicesRecord> findByGuestRegNo(long regNo);
}
