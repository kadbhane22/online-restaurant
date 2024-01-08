package com.online.restaurant.domain;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ordertable")
public class Ordertable {

	private ArrayList<String>orderList;
	private int totatprice;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private String username;
	private Date date;	
	private String status;
	private LocalDateTime expiretime;
	public ArrayList<String> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<String> orderList) {
		this.orderList = orderList;
	}
	public int getTotatprice() {
		return totatprice;
	}
	public void setTotatprice(int totatprice) {
		this.totatprice = totatprice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(LocalDateTime expiretime) {
		this.expiretime = expiretime;
	}



}

