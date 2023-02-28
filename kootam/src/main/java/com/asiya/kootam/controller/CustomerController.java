package com.asiya.kootam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.Customer;
import com.asiya.kootam.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// display list of customers
    @GetMapping("/customer")
    public String viewHomePage(Model model) {
    	//List<Customer> customers = customerService.getAllCustomer();
		model.addAttribute("listCustomers", customerService.getAllCustomer());
	    return "customerList";
		
        
    }
	
	@GetMapping("/customer/showNewCustomerForm")
	public String showNewcustomerForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer_new";
	}
	
	@PostMapping("/customer/saveCustomer")
	public String savecustomer(@ModelAttribute("customer") Customer customer) {
		// save customer to database
		customerService.saveCustomer(customer);
		return "redirect:/customer";
	}
	
	
	
	@GetMapping("/customer/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Customer customer=customerService.getCustomerById(id);
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "customer_update";
	}
	
	@GetMapping("/customer/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.customerService.deleteCustomerById(id);
		return "redirect:/customer";
	}
	
	
}