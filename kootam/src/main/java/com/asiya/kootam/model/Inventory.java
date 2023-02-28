package com.asiya.kootam.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_Id")
	private int invId;

	@JoinColumn(name="it_Id")
	private Item item;
	
	@JoinColumn(name="v_Id")
	private Vendor vendor;
	
	@Column(name = "inv_Unit")
	private int invUnit;

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}


	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getInvUnit() {
		return invUnit;
	}

	public void setInvUnit(int invUnit) {
		this.invUnit = invUnit;
	}
	
	
}