package com.exam.hotel.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.CheckOutTransaction;

@Repository
public interface CheckOutTransactionRepository extends JpaRepository<CheckOutTransaction, Long> {
	
	public List<CheckOutTransaction> findByTransactionDate(Date checkoutDate);

}
