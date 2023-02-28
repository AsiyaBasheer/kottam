package com.asiya.kootam.service;

import java.util.List;

import com.asiya.kootam.model.SaleItem;

public interface SaleItemService {
	List<SaleItem> getAllSaleItems();
	void saveSaleItem(SaleItem saleItem);
	SaleItem getSaleItemById(int id);
	void deleteSaleItemById(int id);
	List<SaleItem> getSaleItemByItemId(int itemId);
	List<SaleItem> getSaleItemBySaleId(int saleId);
	void deleteSaleItemBySaleId(int SaleId);
	
}
