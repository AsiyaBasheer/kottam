package com.asiya.kootam.service;

import java.util.List;

import com.asiya.kootam.model.ItemUOM;

public interface ItemUOMService {
	List<ItemUOM> getAllItemUOM();
	void saveItemUOM(ItemUOM itemUOM);
	ItemUOM getItemUOMById(int id);
	void deleteItemUOMById(int id);
	
}
