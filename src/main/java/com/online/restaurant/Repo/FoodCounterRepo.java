package com.online.restaurant.Repo;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.online.restaurant.domain.ConfirmOrder;
import com.online.restaurant.domain.FoodCounter;

public interface FoodCounterRepo extends CrudRepository<FoodCounter, Integer> {
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO food_counter (date,food) VALUES (?1,?2)")
	public void insertData(LocalDate localdate,String foodname);
	

	@Query(nativeQuery = true,value ="select *,count(*) as cnt from food_counter\r\n"
			+ "	WHERE DATE BETWEEN :n and :f group by food order by cnt desc limit 3") 
	public ArrayList<FoodCounter> topThreeMovingItems(@Param("n")String localdate,@Param("f")String localdate1);
	
	@Query(nativeQuery = true, value = "select *,count(*) as cnt from food_counter group by food order by cnt desc limit 3")
	public ArrayList<FoodCounter> topThreeAllTime();
	
	
//	select food,count(*) as cnt from food_counter
//	WHERE DATE BETWEEN '2022-04-23' and '2022-04-23' group by food order by cnt desc limit 3;
}
