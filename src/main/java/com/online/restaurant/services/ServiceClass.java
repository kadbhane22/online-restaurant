package com.online.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceClass {

	private ArrayList<String> orderList;
	private Integer total;
	private String modestatus,link;
	private String status;

	

	
	
}
