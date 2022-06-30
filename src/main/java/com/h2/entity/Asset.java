package com.h2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String purchaseDate;
	private String condNotes;
	private enum statusType{
		Available,
		Assigned,
		Recovered
	};
	private statusType status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getCondNotes() {
		return condNotes;
	}
	public void setCondNotes(String condNotes) {
		this.condNotes = condNotes;
	}
	
	
	public statusType getStatus() {
		return status;
	}
	public void setStatus(statusType status) {
		this.status = status;
	}
	public Asset(String name, String purchaseDate, String condNotes) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.condNotes = condNotes;
		
	}
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
