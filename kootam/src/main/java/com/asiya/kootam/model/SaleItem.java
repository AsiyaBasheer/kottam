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
public class SaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "si_Id")
	private int siId;

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="it_Id")
	private Item item;
	
	
	
	@Column(name = "si_Qty")
	private int siQty;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "s_Id")
	private Sale sale;

	public int getSiId() {
		return siId;
	}

	public void setSiId(int siId) {
		this.siId = siId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getSiQty() {
		return siQty;
	}

	public void setSiQty(int siQty) {
		this.siQty = siQty;
	}

	

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	


}
