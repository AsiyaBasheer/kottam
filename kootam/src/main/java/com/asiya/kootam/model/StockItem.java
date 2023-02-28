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
public class StockItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sti_Id")
	private int stiId;

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="it_Id")
	private Item item;
	
	
	
	@Column(name = "sti_Qty")
	private int stiQty;
	
	
	@Column(name = "sti_V_Price")
	private float stiVPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "st_Id")
	private Stock stock;
	

	public int getStiId() {
		return stiId;
	}

	public void setStiId(int stiId) {
		this.stiId = stiId;
	}

	

	

	public int getStiQty() {
		return stiQty;
	}

	public void setStiQty(int stiQty) {
		this.stiQty = stiQty;
	}

	

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	

	public float getStiVPrice() {
		return stiVPrice;
	}

	public void setStiVPrice(float stiVPrice) {
		this.stiVPrice = stiVPrice;
	}

	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	

}