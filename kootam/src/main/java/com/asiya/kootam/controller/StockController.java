package com.asiya.kootam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.Stock;
import com.asiya.kootam.service.ItemService;
import com.asiya.kootam.service.StockItemService;
import com.asiya.kootam.service.StockService;
import com.asiya.kootam.service.VendorService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private VendorService vendorService;
	
	
	@Autowired
	private StockItemService stockItemService;
	
	
    @GetMapping("/stock")
    public String viewHomePage(Model model) {
    	model.addAttribute("listStocks", stockService.getAllStocks());
	    return "stock_list";
		
        
    }
	
	@GetMapping("/stock/showNewStockForm")
	public String showNewStockForm(Model model) {
		// create model attribute to bind form data
		Stock stock=new Stock();
		model.addAttribute("stock", stock);
		model.addAttribute("items", itemService.getAllItems());

		model.addAttribute("vendors", vendorService.getAllVendor());
		return "stock_new";
	}
	
	@PostMapping("/stock/saveStock")
	public String saveStock(@ModelAttribute("stock") Stock stock,Model model) {
		// save Stock to database
		Stock stockout=stockService.saveStock(stock);
		
		return "redirect:/stockItem/showNewStockItemForm/"+stockout.getStId();
	}
	
	@PostMapping("/stock/saveStockUpdate")
	public String saveStockUpdate(@ModelAttribute("stock") Stock stock,Model model) {
		// save Stock to database
		Stock stockout=stockService.
				saveStock(stock);
		
		return "redirect:/stockItem/"+stockout.getStId();
	}
	
	
	
	@GetMapping("/stock/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Stock stock=stockService.getStockById(id) ;
		model.addAttribute("stock", stock);
		model.addAttribute("items", itemService.getAllItems());
		return "stock_update";
	}
	
	@GetMapping("/stock/deleteStock/{id}")
	public String deleteStock(@PathVariable (value = "id") int id) {
		//this.stockItemService.deleteStockItemByStockId(id);
		// call delete  method 
		this.stockService.deleteStockById(id);
		return "redirect:/stock";
	}
	
	
}