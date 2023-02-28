package com.asiya.kootam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiya.kootam.model.SaleItem;
import com.asiya.kootam.repository.SaleItemRepository;

@Service
public class SaleItemServiceImpl implements SaleItemService{

	@Autowired
	SaleItemRepository saleItemRepository;
	
	

	@Override
	public List<SaleItem> getAllSaleItems() {
		// TODO Auto-generated method stub
		return saleItemRepository.findAll();
	}

	@Override
	public void saveSaleItem(SaleItem saleItem) {
		saleItemRepository.save(saleItem);
		
	}

	@Override
	public SaleItem getSaleItemById(int id) {
		Optional<SaleItem> optional=saleItemRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("sale Item not found");
		}
	}

	@Override
	public void deleteSaleItemById(int id) {
		this.saleItemRepository.deleteById(id);
		
	}
	
	@Override
	public List<SaleItem> getSaleItemByItemId(int itemId) {
		return this.saleItemRepository.getSaleItemByItemId(itemId);
		
	}
	
	@Override
	public List<SaleItem> getSaleItemBySaleId(int saleId){
		return this.saleItemRepository.getSaleItemBySaleId(saleId);
	}

	@Override
	public void deleteSaleItemBySaleId(int saleId) {
		saleItemRepository.deleteSaleItemBySaleId(saleId);
		
	}


}
