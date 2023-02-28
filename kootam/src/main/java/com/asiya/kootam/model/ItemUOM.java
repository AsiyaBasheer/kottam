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
public class ItemUOM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itUOM_Id")
	private int itUOMId;

	@Column(name = "itUOM_Name")
	private String itUOMName;
	
	
	 @OneToMany(fetch=FetchType.LAZY, mappedBy="itUOM")
	 private Set<Item> items = new HashSet<Item>(0);


	public int getItUOMId() {
		return itUOMId;
	}

	public void setItUOMId(int itUOMId) {
		this.itUOMId = itUOMId;
	}

	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	

	

	public String getItUOMName() {
		return itUOMName;
	}

	public void setItUOMName(String itUOMName) {
		this.itUOMName = itUOMName;
	}
	
	
}
