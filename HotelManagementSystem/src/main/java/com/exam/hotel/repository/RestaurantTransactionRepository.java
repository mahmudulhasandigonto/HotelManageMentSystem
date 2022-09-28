package com.exam.hotel.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.RestaurantTransaction;

@Repository
public interface RestaurantTransactionRepository extends JpaRepository<RestaurantTransaction, Long>{
	
	public List<RestaurantTransaction> findAllByOrderByBillNoDesc();
	
	public List<RestaurantTransaction> findByTransactionDateBetween(Date startDate, Date endDate);
	
	@Query(value="select sum(discount),sum(sub_total),sum(grand_total) from restaurant_transaction where transaction_date  between ?1 and ?2", nativeQuery = true)
	public List<Object[]> findTotalSummary(Date startDate, Date endDate);
	
	@Query(value="select sum(discount),sum(sub_total),sum(grand_total) from restaurant_transaction where transaction_date=?1", nativeQuery = true)
	public List<Object[]> findDailySummary(LocalDate date);

}
