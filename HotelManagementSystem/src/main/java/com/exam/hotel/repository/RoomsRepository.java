package com.exam.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
	  
	public Rooms findByRoomNo(int roomNo);
	
	public List<Rooms> findByRoomStatus(String roomStatus);
		
	
}
