package com.asiya.kootam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itcat_Id")
	private int itcatId;

	@Column(name = "itcat_Name")
	private String itcatName;
	
	
	 @OneToMany(fetch=FetchType.LAZY, mappedBy="itemCategory")
	 
	private Set<Item> items = new HashSet<Item>(0);


	public int getItcatId() {
		return itcatId;
	}

	public void setItcatId(int itcatId) {
		this.itcatId = itcatId;
	}

	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	

	

	public String getItcatName() {
		return itcatName;
	}

	public void setItcatName(String itcatName) {
		this.itcatName = itcatName;
	}
	
	
}