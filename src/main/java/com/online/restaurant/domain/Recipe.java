package com.online.restaurant.domain;

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
@Table(name = "Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Category;
	private String NameOfItem;
	private String description;
	private String Ingredients;
	private String steps;
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(String category, String nameOfItem, String description, String ingredients, String steps) {
		super();
		Category = category;
		NameOfItem = nameOfItem;
		this.description = description;
		Ingredients = ingredients;
		this.steps = steps;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getNameOfItem() {
		return NameOfItem;
	}
	public void setNameOfItem(String nameOfItem) {
		NameOfItem = nameOfItem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return Ingredients;
	}
	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	

}
