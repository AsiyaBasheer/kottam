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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_Id")
	private int custId;
	
	@Column(name = "cust_Phone",unique = true)
	
	private int custPhone;

	@Column(name = "cust_Name")
	private String custName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")
	private Address address;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	 @Temporal(TemporalType.DATE)
	@Column(name = "cust_Date_Of_Join")
	private Date custDateOfJoin;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="customer",cascade = CascadeType.REMOVE)
	private Set<Sale> sale = new HashSet<Sale>(0);


	public int getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(int custPhone) {
		this.custPhone = custPhone;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getCustDateOfJoin() {
		return custDateOfJoin;
	}

	public void setCustDateOfJoin(Date custDateOfJoin) {
		this.custDateOfJoin = custDateOfJoin;
	}

	
	
	
}