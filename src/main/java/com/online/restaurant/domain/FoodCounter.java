package com.online.restaurant.domain;

import java.time.LocalDate;

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
@Table(name="foodCounter")
public class FoodCounter {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int foodno;
	LocalDate date;
	String food;

}
