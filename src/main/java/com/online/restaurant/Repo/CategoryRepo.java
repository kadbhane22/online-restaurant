package com.online.restaurant.Repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.online.restaurant.domain.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer>{

	@Query(nativeQuery = true,value ="SELECT * FROM category WHERE date =:n") 
	public ArrayList<Category>  getOrdersByCategory(@Param("n") LocalDate localDate);
}
