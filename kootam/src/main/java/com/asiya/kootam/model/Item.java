package com.asiya.kootam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "it_Id")
	private int itId;

	@Column(name = "it_Name")
	private String itName;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="itcat_Id")
	private ItemCategory itemCategory;

	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="itUOM_Id")
	private ItemUOM itUOM;
	
	@Column(name = "it_Price")
	private float itPrice;
	
	
	
	
	public float getItPrice() {
		return itPrice;
	}

	public void setItPrice(float itPrice) {
		this.itPrice = itPrice;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItId() {
		return itId;
	}

	public void setItId(int itId) {
		this.itId = itId;
	}

	public String getItName() {
		return itName;
	}

	public void setItName(String itName) {
		this.itName = itName;
	}

	public ItemUOM getItUOM() {
		return itUOM;
	}

	public void setItUOM(ItemUOM itUOM) {
		this.itUOM = itUOM;
	}

	
	
	
	
	
	
	
	
}