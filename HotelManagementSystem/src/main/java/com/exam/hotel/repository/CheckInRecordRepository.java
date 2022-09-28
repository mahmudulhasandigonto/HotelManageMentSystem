package com.exam.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.CheckInRecord;

@Repository
public interface CheckInRecordRepository extends JpaRepository<CheckInRecord, Long> {

}
