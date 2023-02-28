package com.asiya.kootam.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_Id")
	private int stId;


	
	 @DateTimeFormat(pattern = "yyyy-mm-dd")
	 @Temporal(TemporalType.DATE)
	@Column(name = "st_Date")
	private Date stDate;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "v_Id")
	private Vendor vendor;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="stock",cascade = CascadeType.ALL)
	private Set<StockItem> stockItems = new HashSet<StockItem>(0);

	
	@Column(name = "st_AmountSettled")
	private boolean stAmountSettled;
	
	

	public int getStId() {
		return stId;
	}

	public void setStId(int stkId) {
		this.stId = stkId;
	}


	

	public Date getStDate() {
		return stDate;
	}

	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}

	

	


	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	

	public Set<StockItem> getStockItems() {
		return stockItems;
	}

	public void setStockItems(Set<StockItem> stockItems) {
		this.stockItems = stockItems;
	}

	public boolean isStAmountSettled() {
		return stAmountSettled;
	}

	public void setStAmountSettled(boolean stAmountSettled) {
		this.stAmountSettled = stAmountSettled;
	}
	
	
	
}
