package com.h2.entity;

public class Asset {

	private String name;
	private String purchaseDate;
	private String condNotes;
	private Enum status;
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
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
	}
	public Asset(String name, String purchaseDate, String condNotes, Enum status) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.condNotes = condNotes;
		this.status = status;
	}
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
