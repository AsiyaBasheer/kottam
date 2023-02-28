package com.asiya.kootam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.SaleItem;
import com.asiya.kootam.service.ItemService;
import com.asiya.kootam.service.SaleItemService;
import com.asiya.kootam.service.SaleService;

@Controller
public class SaleItemController {

	@Autowired
	private SaleItemService saleItemService;
	
	
	@Autowired
	private ItemService itemService;
	
	
	@Autowired
	private SaleService saleService;
	
	
   // @GetMapping("/saleItem")
    public String viewHomePage(Model model) {
    	model.addAttribute("listSaleItems", saleItemService.getAllSaleItems());
	    return "saleItem_list";
		
        
    }
    
    @GetMapping("/saleItem/{saleId}")
    public String showFormForSaveItemList
    	(@PathVariable ( value = "saleId") int saleId, Model model) {
    		List<SaleItem> saleItems=saleItemService.getSaleItemBySaleId(saleId) ;
    		model.addAttribute("listSaleItems", saleItems);
    		model.addAttribute("saleId",saleId);
    	    return "saleItem_list";     
    }
    
  
	
	@GetMapping("/saleItem/showNewSaleItemForm")
	public String showNewSaleItemForm(Model model) {
		System.out.println("Inside showNewSaleItemForm: "+ model.getAttribute("sale"));
		// create model attribute to bind form data
		SaleItem saleItem=new SaleItem();
		model.addAttribute("saleItem", saleItem);
		model.addAttribute("items", itemService.getAllItems());
		return "saleItem_new";
	}
	@GetMapping("/saleItem/showNewSaleItemForm/{saleId}")
	public String showNewSaleItemForm(@PathVariable ( value = "saleId") int saleId, Model model) {
		// create model attribute to bind form data
		SaleItem saleItem=new SaleItem();
		model.addAttribute("saleItem", saleItem);
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("sale", saleService.getSaleById(saleId));
		
		return "saleItem_new";
	}
	
	@PostMapping("/saleItem/saveSaleItem")
	public String savesaleItem(@ModelAttribute("saleItem") SaleItem saleItem) {
		// save saleItem to database
		//System.out.println("saleId"+saleItem.getSale().getStId());
		saleItemService.saveSaleItem(saleItem);
		System.out.println("save***");
		
		return "redirect:/saleItem/"+saleItem.getSale().getsId();
	}
	
	
	
	@GetMapping("/saleItem/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		System.out.println("update sales item");
		SaleItem saleItem=saleItemService.getSaleItemById(id) ;
		model.addAttribute("saleItem", saleItem);
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("sale", saleItem.getSale());
		return "saleItem_update";
	}
	
	@GetMapping("/saleItem/deleteSaleItem/{id}")
	public String deleteSaleItem(@PathVariable (value = "id") int id) {
		SaleItem saleItem=saleItemService.getSaleItemById(id);
		int saleId=saleItem.getSale().getsId();
		// call delete  method 
		this.saleItemService.deleteSaleItemById(id);
		return "redirect:/saleItem/"+saleId;
	}
	
	
}
