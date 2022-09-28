package com.exam.hotel.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

	public List<Booking> findByCheckOut(Date todaysDate);
	public List<Booking> findByCheckind(Date todaysDate);

	
}
