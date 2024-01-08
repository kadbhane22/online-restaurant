package com.online.restaurant.Repo;

import org.springframework.data.repository.CrudRepository;

import com.online.restaurant.domain.Recipe;

public interface RecipeRepo extends CrudRepository<Recipe, String>{

}
