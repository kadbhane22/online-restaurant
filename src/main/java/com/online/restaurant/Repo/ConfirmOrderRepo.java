package com.online.restaurant.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.online.restaurant.domain.ConfirmOrder;


public interface ConfirmOrderRepo extends CrudRepository<ConfirmOrder, Integer>{


	@Query(nativeQuery = true,value ="SELECT * FROM confirm_order u WHERE u.username =:n") 
	public ArrayList<ConfirmOrder>  getByUserName(@Param("n") String username);
}
