package com.asiya.kootam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private int addrid;
	
	@Column(name = "addr_HouseName")
	private String addrHouseName;
	
	@Column(name = "addr_Street")
	private String addrStreet;
	
	@Column(name = "addr_PO")
	private String addPO;

	@Column(name = "addr_District")
	private String addrDistrict;
	
	@Column(name = "addr_State")
	private String addrState;
	
	@Column(name = "addr_Country")
	private String addrCountry;
	
	
	
	@Column(name = "addr_Pincode")
	private String addrPincode;
	
	

	
	public int getAddrid() {
		return addrid;
	}



	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}



	public String getAddrHouseName() {
		return addrHouseName;
	}



	public void setAddrHouseName(String addrHouseName) {
		this.addrHouseName = addrHouseName;
	}



	public String getAddrStreet() {
		return addrStreet;
	}



	public void setAddrStreet(String addrStreet) {
		this.addrStreet = addrStreet;
	}



	public String getAddPO() {
		return addPO;
	}



	public void setAddPO(String addPO) {
		this.addPO = addPO;
	}



	public String getAddrDistrict() {
		return addrDistrict;
	}



	public void setAddrDistrict(String addrDistrict) {
		this.addrDistrict = addrDistrict;
	}



	public String getAddrState() {
		return addrState;
	}



	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}



	public String getAddrCountry() {
		return addrCountry;
	}



	public void setAddrCountry(String addrCountry) {
		this.addrCountry = addrCountry;
	}



	public String getAddrPincode() {
		return addrPincode;
	}



	public void setAddrPincode(String addrPincode) {
		this.addrPincode = addrPincode;
	}


}