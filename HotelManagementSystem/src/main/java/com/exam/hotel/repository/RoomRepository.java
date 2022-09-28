package com.exam.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
