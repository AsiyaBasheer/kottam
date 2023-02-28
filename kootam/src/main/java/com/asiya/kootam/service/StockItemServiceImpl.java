package com.asiya.kootam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiya.kootam.model.StockItem;
import com.asiya.kootam.repository.StockItemRepository;

@Service
public class StockItemServiceImpl implements StockItemService{

	@Autowired
	StockItemRepository stockItemRepository;
	
	

	@Override
	public List<StockItem> getAllStockItems() {
		// TODO Auto-generated method stub
		return stockItemRepository.findAll();
	}

	@Override
	public void saveStockItem(StockItem stockItem) {
		stockItemRepository.save(stockItem);
		
	}

	@Override
	public StockItem getStockItemById(int id) {
		Optional<StockItem> optional=stockItemRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Stock Item not found");
		}
	}

	@Override
	public void deleteStockItemById(int id) {
		this.stockItemRepository.deleteById(id);
		
	}
	
	@Override
	public StockItem getStockItemByItemId(int itemId) {
		return this.stockItemRepository.getStockItemByItemId(itemId);
		
	}
	
	@Override
	public List<StockItem> getStockItemByStockId(int stockId){
		return this.stockItemRepository.getStockItemByStockId(stockId);
	}

	@Override
	public void deleteStockItemByStockId(int stockId) {
		// TODO Auto-generated method stub
		stockItemRepository.deleteStockItemByStockId( stockId);
	}

	
}
