package com.online.restaurant.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	 private ArrayList<String> breakfast;
	
	private String user;
	private ArrayList<String> veg;
	private ArrayList<String> nonveg;
	private ArrayList<String> juices;
	private ArrayList<String> bakery;
	private ArrayList<String> italian;
	private ArrayList<String> continental;
	private LocalDate date;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="category" )
	private OlderOrderTable olderorder;
	@Id
	private int orderid;
	public ArrayList<String> getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(ArrayList<String> breakfast) {
		this.breakfast = breakfast;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public ArrayList<String> getVeg() {
		return veg;
	}
	public void setVeg(ArrayList<String> veg) {
		this.veg = veg;
	}
	public ArrayList<String> getNonveg() {
		return nonveg;
	}
	public void setNonveg(ArrayList<String> nonveg) {
		this.nonveg = nonveg;
	}
	public ArrayList<String> getJuices() {
		return juices;
	}
	public void setJuices(ArrayList<String> juices) {
		this.juices = juices;
	}
	public ArrayList<String> getBakery() {
		return bakery;
	}
	public void setBakery(ArrayList<String> bakery) {
		this.bakery = bakery;
	}
	public ArrayList<String> getItalian() {
		return italian;
	}
	public void setItalian(ArrayList<String> italian) {
		this.italian = italian;
	}
	public ArrayList<String> getContinental() {
		return continental;
	}
	public void setContinental(ArrayList<String> continental) {
		this.continental = continental;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public OlderOrderTable getOlderorder() {
		return olderorder;
	}
	public void setOlderorder(OlderOrderTable olderorder) {
		this.olderorder = olderorder;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	
}
