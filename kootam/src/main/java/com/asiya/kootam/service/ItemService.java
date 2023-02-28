package com.asiya.kootam.service;

import java.util.List;

import com.asiya.kootam.model.Item;

public interface ItemService {
	List<Item> getAllItems();
	void saveItem(Item item);
	Item getItemById(int id);
	void deleteItemById(int id);
	
}