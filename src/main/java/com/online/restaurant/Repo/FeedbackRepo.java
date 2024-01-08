package com.online.restaurant.Repo;

import org.springframework.data.repository.CrudRepository;

import com.online.restaurant.domain.Feedback;

public interface FeedbackRepo extends CrudRepository<Feedback, Integer> {

}
