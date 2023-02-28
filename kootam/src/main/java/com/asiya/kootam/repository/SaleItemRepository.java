package com.asiya.kootam.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {

	@Query("SELECT c FROM SaleItem AS c WHERE c.item.itId = ?1 ")
	List<SaleItem> getSaleItemByItemId(int itemId);
	

	@Query("SELECT c FROM SaleItem AS c WHERE c.sale.sId = ?1 ")
	List<SaleItem> getSaleItemBySaleId(int saleId);
	
	@Transactional
	@Modifying
	@Query("DELETE  FROM SaleItem  WHERE sale.sId = ?1 ")
	void deleteSaleItemBySaleId(int saleId);
}