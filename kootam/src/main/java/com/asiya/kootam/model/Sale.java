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
public class Sale {

	//invoice number
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_Id")
	private int sId;

	
	
	 @DateTimeFormat(pattern = "yyyy-mm-dd")
	 @Temporal(TemporalType.DATE)
	@Column(name = "s_Date")
	private Date sDate;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cust_Id")
	private Customer customer;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sale",cascade = CascadeType.ALL)
	private Set<SaleItem> saleItems = new HashSet<SaleItem>(0);

	
	@Column(name = "s_AmountSettled")
	private boolean sAmountSettled;


	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	

	public Date getsDate() {
		return sDate;
	}


	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	


	public Set<SaleItem> getSaleItems() {
		return saleItems;
	}


	public void setSaleItems(Set<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}


	public boolean issAmountSettled() {
		return sAmountSettled;
	}


	public void setsAmountSettled(boolean sAmountSettled) {
		this.sAmountSettled = sAmountSettled;
	}
	
	
	
	
}