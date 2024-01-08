package com.online.restaurant.Repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.online.restaurant.domain.ConfirmOrder;
import com.online.restaurant.domain.OlderOrderTable;
import com.online.restaurant.domain.Ordertable;

public interface OlderOrderRepo extends CrudRepository<OlderOrderTable, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM ordertable WHERE  status=\"Cancel\" AND username=:n ")
	public ArrayList<Ordertable> cancleStatus(@Param("n") String status);

	@Query(nativeQuery = true, value = "select * from older_order_table where username=:n")
	public ArrayList<OlderOrderTable> getOrderDetails(@Param("n") String username);

	@Query(nativeQuery = true, value = "SELECT * FROM older_order_table u WHERE u.username =:n")
	public ArrayList<OlderOrderTable> getByUserName(@Param("n") String username);

	@Query(nativeQuery = true, value = "SELECT * FROM older_order_table u WHERE u.date =:n")
	public ArrayList<OlderOrderTable> getByUserDate(@Param("n") String date);
}