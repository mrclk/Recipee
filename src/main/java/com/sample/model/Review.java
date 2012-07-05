package com.sample.model;

import org.joda.time.DateTime;

public class Review {

	private Recipe recipe;
	private Rating ratingStars;
	private DateTime ratingDate;
	private String reviewText;

	public Review(Recipe recipe, Rating ratingStars, DateTime ratingDate,
			String reviewText) {
		this.recipe = recipe;
		this.ratingStars = ratingStars;
		this.ratingDate = ratingDate;
		this.reviewText = reviewText;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Rating getRatingStars() {
		return ratingStars;
	}

	public void setRatingStars(Rating ratingStars) {
		this.ratingStars = ratingStars;
	}

	public DateTime getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(DateTime ratingDate) {
		this.ratingDate = ratingDate;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

}
