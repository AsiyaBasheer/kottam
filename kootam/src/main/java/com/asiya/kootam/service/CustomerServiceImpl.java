package com.asiya.kootam.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiya.kootam.model.Customer;
import com.asiya.kootam.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Optional<Customer> optional=customerRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Customer not found");
		}
	}

	@Override
	public void deleteCustomerById(int id) {
		this.customerRepository.deleteById(id);
		
	}

	@Override
	public List<Customer> findCustomersOnDate(Date date) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomersOnDate(date);
	}
	
	@Override
	public List<Customer> findCustomersAfterDate(Date date) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomersAfterDate(date);
	}

}