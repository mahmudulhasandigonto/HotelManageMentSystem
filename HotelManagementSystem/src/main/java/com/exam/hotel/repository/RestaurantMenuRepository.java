package com.exam.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.RestaurantMenu;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {
	
	public RestaurantMenu findByItemName(String itemname);

}
