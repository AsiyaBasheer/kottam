package com.asiya.kootam.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiya.kootam.model.Vendor;
import com.asiya.kootam.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository vendorRepository;
	
	@Override
	public List<Vendor> getAllVendor() {
		return vendorRepository.findAll();
	}

	@Override
	public void saveVendor(Vendor vendor) {
		vendorRepository.save(vendor);
		
	}

	@Override
	public Vendor getVendorById(int id) {
		
		Optional<Vendor> optional=vendorRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Vendor not found");
		}
	}

	@Override
	public void deleteVendorById(int id) {
		
		this.vendorRepository.deleteById(id);
		
	}
	
	@Override
	public List<Vendor> findVendorsOnDate(Date date) {
		// TODO Auto-generated method stub
		return vendorRepository.findVendorsOnDate(date);
	}
	
	@Override
	public List<Vendor> findVendorsAfterDate(Date date) {
		// TODO Auto-generated method stub
		return vendorRepository.findVendorsAfterDate(date);
	}

}
