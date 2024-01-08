package com.online.restaurant.Repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.online.restaurant.domain.Ordertable;

public interface OrderRepo extends CrudRepository<Ordertable, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Ordertable WHERE username=:n ORDER by orderid DESC LIMIT 1")
	public Ordertable getlastOrderByUSerName(@Param("n") String username);

	@Query(nativeQuery = true, value = "DELETE FROM Ordertable WHERE date=:n")
	public void deleteByDate(@Param("n") Date date);

	@Query(nativeQuery = true, value = "SELECT * FROM Ordertable WHERE  status=\"Open\" AND username=:n ")
	public ArrayList<Ordertable> openStatus(@Param("n") String status);

	@Query(nativeQuery = true, value = "SELECT * FROM Ordertable WHERE username=:n ")
	public ArrayList<Ordertable> openconfirmStatus(@Param("n") String username);

	@Query(nativeQuery = true, value = "SELECT * FROM Ordertable WHERE orderid=:n ")
	public Ordertable getById(@Param("n") Integer id);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE Ordertable SET status=\"Confirm\" WHERE orderid=:n ")
	public void confirmOrderStatus(@Param("n") Integer id);

	@Query(nativeQuery = true, value = "SELECT * FROM Ordertable WHERE  status=\"Open\" ")
	public ArrayList<Ordertable> openStatusAdmin();

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE Ordertable SET status=\"Completed\" WHERE orderid=:n ")
	public void completedOrderStatus(@Param("n") Integer id);

	@Query(nativeQuery = true,value ="SELECT * FROM Ordertable WHERE  status=\"Open\" AND username=:n")
	public 	List<Ordertable> getExpiryOrderDetail(@Param("n") String username);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM Ordertable WHERE status=\"Open\" AND expiretime=:n")
	public int deleteExpiryOrderDetail(@Param("n") LocalDateTime localTime);
	
	
	
}
