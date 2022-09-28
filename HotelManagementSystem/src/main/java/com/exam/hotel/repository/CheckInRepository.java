package com.exam.hotel.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long>{
	
	public List<CheckIn> findByGuestRoomNo(int roomNo);
	
	public List<CheckIn> findByGuestCheckin(Date todaysDate);
	public List<CheckIn> findByGuestCheckout(Date todaysDate);
	
	@Query(value="select sum(guest_adult) from check_in", nativeQuery=true)
	public Integer findTotalGuest();


}
