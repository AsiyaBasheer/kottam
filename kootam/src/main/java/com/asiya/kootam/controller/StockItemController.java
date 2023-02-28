package com.asiya.kootam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.StockItem;
import com.asiya.kootam.service.ItemService;
import com.asiya.kootam.service.StockItemService;
import com.asiya.kootam.service.StockService;

@Controller
public class StockItemController {

	@Autowired
	private StockItemService stockItemService;
	
	
	@Autowired
	private ItemService itemService;
	
	
	@Autowired
	private StockService stockService;
	
	
   // @GetMapping("/stockItem")
    public String viewHomePage(Model model) {
    	model.addAttribute("listStockItems", stockItemService.getAllStockItems());
	    return "stockItem_list";
		
        
    }
    

	@GetMapping("/stockItem/{stockId}")
	public String showFormForStockItemList(@PathVariable ( value = "stockId") int stockId, Model model) {
		List<StockItem> stockItems=stockItemService.getStockItemByStockId(stockId) ;
		model.addAttribute("listStockItems", stockItems);
		model.addAttribute("stockId",stockId);
	    return "stockItem_list";
	}
	
	
	@GetMapping("/stockItem/showNewStockItemForm/{stockId}")
	public String showNewStockItemForm(@PathVariable ( value = "stockId") int stockId, Model model) {
		// create model attribute to bind form data
		StockItem stockItem=new StockItem();
		model.addAttribute("stockItem", stockItem);
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("stock", stockService.getStockById(stockId));
		
		return "stockItem_new";
	}
	
	@PostMapping("/stockItem/saveStockItem")
	public String savestockItem(@ModelAttribute("stockItem") StockItem stockItem) {
		// save stockItem to database
		System.out.println("stockId"+stockItem.getStock().getStId());
		stockItemService.saveStockItem(stockItem);
		System.out.println("save***");
		
		return "redirect:/stockItem/"+stockItem.getStock().getStId();
	}
	
	
	
	@GetMapping("/stockItem/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		StockItem stockItem=stockItemService.getStockItemById(id) ;
		model.addAttribute("stockItem", stockItem);
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("stock", stockItem.getStock());
		return "stockItem_update";
	}
	
	@GetMapping("/stockItem/deleteStockItem/{id}")
	public String deleteStockItem(@PathVariable (value = "id") int id) {
		StockItem stockItem=stockItemService.getStockItemById(id);
		int stockId=stockItem.getStock().getStId();
		// call delete  method 
		this.stockItemService.deleteStockItemById(id);
		return "redirect:/stockItem/"+stockId;
	}
	
	
}