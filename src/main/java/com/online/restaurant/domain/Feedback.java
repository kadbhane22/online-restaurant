package com.online.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackID;
	private String username;
	private int rating;
	private String feedback;
	
//	@OneToOne
//	@JoinColumn(name="orederid")
//	private Ordertable ordertable;
//	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Feedback(String username, int rating, String feedback) {
		super();
		this.username = username;
		this.rating = rating;
		this.feedback = feedback;
		
	}



	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	
	
	


	
	
}
