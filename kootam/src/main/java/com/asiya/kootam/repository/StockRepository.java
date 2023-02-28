package com.asiya.kootam.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Query("SELECT c FROM Stock AS c WHERE c.stDate= ?1 ")
	List<Stock> findStocksOnDate(Date date);
	
	@Query("SELECT c FROM Stock AS c WHERE c.stDate>= ?1 ")
	List<Stock> findStocksAfterDate(Date date);
}
