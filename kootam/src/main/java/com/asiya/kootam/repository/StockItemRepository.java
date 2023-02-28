package com.asiya.kootam.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.StockItem;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Integer> {

	
	@Query("SELECT c FROM StockItem AS c WHERE c.item.itId = ?1 ")
	StockItem getStockItemByItemId(int itemId);
	
	@Query("SELECT c FROM StockItem AS c WHERE c.stock.stId = ?1 ")
	List<StockItem> getStockItemByStockId(int stockId);
	
	@Transactional
	@Modifying
	@Query("DELETE  FROM StockItem  WHERE stock.stId = ?1 ")
	void deleteStockItemByStockId(int stockId);
}
