package com.asiya.kootam.service;

import java.util.Date;
import java.util.List;

import com.asiya.kootam.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer();
	void saveCustomer(Customer customer);
	Customer getCustomerById(int id);
	void deleteCustomerById(int id);
	List<Customer> findCustomersOnDate(Date date );
	List<Customer> findCustomersAfterDate(Date date );
	
}

