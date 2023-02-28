package com.asiya.kootam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asiya.kootam.model.Inventory;
import com.asiya.kootam.model.SaleItem;
import com.asiya.kootam.model.StockItem;
import com.asiya.kootam.service.SaleItemService;
import com.asiya.kootam.service.StockItemService;

@Controller
public class InventoryController {

	@Autowired
	private StockItemService stockItemService;
	

	@Autowired
	private SaleItemService saleItemService;
	
	
	
	
    @GetMapping("/inventory")
    public String viewHomePage(Model model) {
    	List<StockItem> lsI=stockItemService.getAllStockItems();
    	List<Inventory> lIn=new ArrayList<Inventory>();
    	for (StockItem st:lsI) {
    		
    		List<SaleItem> lsaleItem=saleItemService.getSaleItemByItemId(st.getItem().getItId());
    		int totalQty=st.getStiQty();
    		for (SaleItem sItem:lsaleItem) {
    			
    			totalQty=totalQty-sItem.getSiQty();
    		}
    		Inventory inv=new Inventory();
    		inv.setItem(st.getItem());
    		inv.setVendor(st.getStock().getVendor());
    		inv.setInvUnit(totalQty);
    		lIn.add(inv);
    		
    	}
    	model.addAttribute("listInventory", lIn);
	    return "inventory_list";
		
        
    }
    
    @GetMapping("/inventory/{itId}")
	public String inventoryById(@PathVariable ( value = "itId") int id, Model model) {
		// create model attribute to bind form data
		
		List<Inventory> lIn=new ArrayList<Inventory>();
    		StockItem st=stockItemService.getStockItemByItemId(id);
    		List<SaleItem> lsaleItem=saleItemService.getSaleItemByItemId(st.getItem().getItId());
    		int totalQty=st.getStiQty();
    		for (SaleItem sItem:lsaleItem) {
    			
    			totalQty=totalQty-sItem.getSiQty();
    		}
    		Inventory inv=new Inventory();
    		inv.setItem(st.getItem());
    		inv.setVendor(st.getStock().getVendor());
    		inv.setInvUnit(totalQty);
    		lIn.add(inv);
    		
    	
    	model.addAttribute("listInventory", lIn);
	    return "inventory_list";
	}
	
	
}