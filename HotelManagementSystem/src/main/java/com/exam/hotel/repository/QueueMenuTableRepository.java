package com.exam.hotel.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.hotel.entity.QueueMenuTable;

@Repository
@Transactional
public interface QueueMenuTableRepository extends JpaRepository<QueueMenuTable, Integer> {

	public List<QueueMenuTable> findByTableNo(String tableno);

	@Query(value = "select distinct(table_no) from queue_menu_table", nativeQuery = true)
	public List<String> finduniquetablNo();

	@Query(value = "select sum(total_price) from queue_menu_table where table_no=?1", nativeQuery = true)
	public long findTotalPrice(String tableno);

	@Modifying
	@Query(value = "delete from queue_menu_table where table_no=?1", nativeQuery = true)
	public void deleteAllbytableno(String tableno);
}
