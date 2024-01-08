package com.online.restaurant.domain;


import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ConfirmOrder")
public class ConfirmOrder {


	private ArrayList<String>orderList;
	private String date;
	private String username;
	@Id
	private int orderid;
	private int total;


	


}