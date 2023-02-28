package com.asiya.kootam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.ItemCategory;
import com.asiya.kootam.service.ItemCategoryService;

@Controller
public class ItemCategoryController {

	@Autowired
	private ItemCategoryService itemCategoryService;
	
	// display list of itemCategory
    @GetMapping("/itemCategory")
    public String viewHomePage(Model model) {
    	//List<ItemCategory> itemCategory = itemCategoryService.getAllItemCategory();
		model.addAttribute("listitemCategory", itemCategoryService.getAllItemCategory());
	    return "itemCategory_list";
		
        
    }
	
	@GetMapping("/itemCategory/showNewItemCategoryForm")
	public String showNewItemCategoryForm(Model model) {
		// create model attribute to bind form data
		ItemCategory itemCategory = new ItemCategory();
		model.addAttribute("itemCategory", itemCategory);
		return "itemCategory_new";
	}
	
	@PostMapping("/itemCategory/saveItemCategory")
	public String saveItemCategory(@ModelAttribute("itemCategory") ItemCategory itemCategory) {
		itemCategoryService.saveItemCategory(itemCategory);
		return "redirect:/itemCategory";
	}
	
	
	
	@GetMapping("/itemCategory/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		ItemCategory itemCategory =itemCategoryService.getItemCategoryById(id);
		// set  as a model attribute to pre-populate the form
		model.addAttribute("itemCategory", itemCategory);
		return "itemCategory_update";
	}
	
	@GetMapping("/itemCategory/deleteItemCategory/{id}")
	public String deleteItemCategory(@PathVariable (value = "id") int id) {
		
		// call delete  method 
		this.itemCategoryService.deleteItemCategoryById(id);
		return "redirect:/itemCategory";
	}
	
	
}
