package com.asiya.kootam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.ItemUOM;
import com.asiya.kootam.service.ItemUOMService;

@Controller
public class ItemUOMController {

	@Autowired
	private ItemUOMService itemUOMService;
	
	// display list of itemUOM
    @GetMapping("/itemUOM")
    public String viewHomePage(Model model) {
    	//List<ItemUOM> itemUOM = itemUOMService.getAllItemUOM();
		model.addAttribute("listitemUOM", itemUOMService.getAllItemUOM());
	    return "itemUOM_list";
		
        
    }
	
	@GetMapping("/itemUOM/showNewItemUOMForm")
	public String showNewItemUOMForm(Model model) {
		// create model attribute to bind form data
		ItemUOM itemUOM = new ItemUOM();
		model.addAttribute("itemUOM", itemUOM);
		return "itemUOM_new";
	}
	
	@PostMapping("/itemUOM/saveItemUOM")
	public String saveItemUOM(@ModelAttribute("itemUOM") ItemUOM itemUOM) {
		itemUOMService.saveItemUOM(itemUOM);
		return "redirect:/itemUOM";
	}
	
	
	
	@GetMapping("/itemUOM/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		ItemUOM itemUOM =itemUOMService.getItemUOMById(id);
		// set  as a model attribute to pre-populate the form
		model.addAttribute("itemUOM", itemUOM);
		return "itemUOM_update";
	}
	
	@GetMapping("/itemUOM/deleteItemUOM/{id}")
	public String deleteItemUOM(@PathVariable (value = "id") int id) {
		
		// call delete  method 
		this.itemUOMService.deleteItemUOMById(id);
		return "redirect:/itemUOM";
	}
	
	
}