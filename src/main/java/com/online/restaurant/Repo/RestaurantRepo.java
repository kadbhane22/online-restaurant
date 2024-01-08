package com.online.restaurant.Repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.online.restaurant.domain.FoodCounter;
import com.online.restaurant.domain.Registration;


public interface RestaurantRepo extends CrudRepository<Registration, String>{

	@Query(nativeQuery = true,value ="select * from Customer where email=:n and password=:f") 
	public Registration fetchByEmailAndPassword(@Param("n")String email,@Param("f")String password);

	@Query(nativeQuery = true,value ="select * from Customer where email=:n") 
	public Registration fetchByEmail(@Param("n")String email);
	
}
