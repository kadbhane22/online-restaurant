package com.online.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class Admin {

	 @Id
	private int totalordercount;

	public int getTotalordercount() {
		return totalordercount;
	}

	public void setTotalordercount(int totalordercount) {
		this.totalordercount = totalordercount;
	}
	 
}
