package com.online.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Customer {

	private int customerId;
	private String customerFname;
	private String customerLname;
	private String customerEmail;
	private double customerPhone;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerFname, String customerLname, String customerEmail,
			double customerPhone) {
		super();
		this.customerId = customerId;
		this.customerFname = customerFname;
		this.customerLname = customerLname;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}
	
	
	
}
