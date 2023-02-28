package com.asiya.kootam.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiya.kootam.model.Stock;
import com.asiya.kootam.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepository;
	
	

	@Override
	public List<Stock> getAllStocks() {
				return stockRepository.findAll();
	}

	@Override
	public Stock saveStock(Stock Stock) {
		System.out.println(stockRepository.save(Stock).getStId());
		return stockRepository.save(Stock);
		
	}

	@Override
	public Stock getStockById(int id) {
		Optional<Stock> optional=stockRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Stock not found");
		}
	}

	@Override
	public void deleteStockById(int id) {
		this.stockRepository.deleteById(id);
		
	}
	
	
	@Override
	public List<Stock> findStocksOnDate(Date date) {
		// TODO Auto-generated method stub
		return stockRepository.findStocksOnDate(date);
	}
	
	@Override
	public List<Stock> findStocksAfterDate(Date date) {
		// TODO Auto-generated method stub
		return stockRepository.findStocksAfterDate(date);
	}


}
