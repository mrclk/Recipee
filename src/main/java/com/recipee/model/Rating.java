package com.recipee.model;

public enum Rating {

	ONE_STAR(1), TWO_STAR(2), THREE_STAR(3), FOUR_STAR(4), FIVE_STAR(5), 
	SIX_STAR(6);

	private int ratingVal;

	private Rating(int ratingVal) {
		this.ratingVal = ratingVal;
	}

	public int getRatingVal() {
		return ratingVal;
	}

}
