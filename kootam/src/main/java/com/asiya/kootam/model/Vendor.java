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
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_Id")
	private int vId;

	@Column(name = "v_Name")
	private String vName;
	
	@Column(name = "v_Phone",unique = true)
	
	private String vPhone;

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")
	private Address address;
	
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor",cascade = CascadeType.REMOVE)
	private Set<Stock> stock = new HashSet<Stock>(0);

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	 @Temporal(TemporalType.DATE)
	@Column(name = "v_Date_Of_Join")
	private Date vDateOfJoin;
	
	

	public String getvPhone() {
		return vPhone;
	}

	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getvDateOfJoin() {
		return vDateOfJoin;
	}

	public void setvDateOfJoin(Date vDateOfJoin) {
		this.vDateOfJoin = vDateOfJoin;
	}
	
	
}
