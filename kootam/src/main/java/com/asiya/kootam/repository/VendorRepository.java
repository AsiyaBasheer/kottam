package com.asiya.kootam.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	@Query("SELECT c FROM Vendor AS c WHERE c.vDateOfJoin= ?1 ")
	List<Vendor> findVendorsOnDate(Date date);
	
	@Query("SELECT c FROM Vendor AS c WHERE c.vDateOfJoin>= ?1 ")
	List<Vendor> findVendorsAfterDate(Date date);
}
