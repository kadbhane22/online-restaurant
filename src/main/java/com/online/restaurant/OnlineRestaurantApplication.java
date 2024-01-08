package com.online.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.online.Exception","com.online.restaurant.controller","com.online.restaurant.services"})
@SpringBootApplication
public class OnlineRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineRestaurantApplication.class, args);
	}

}
