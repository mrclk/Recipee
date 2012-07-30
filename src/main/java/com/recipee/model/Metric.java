package com.recipee.model;

public enum Metric {

	PIECE("recipee.metric.piece"), 
	TEASPOON("recipee.metric.teaspoon"), 
	TABLESPOON("recipee.metric.tablespoon"), 
	MILILITER("recipee.metric.mililiter"), 
	LITER("recipee.metric.liter"), 
	GRAM("recipee.metric.gram"), 
	KILOGRAM("recipee.metric.kilogram"), 
	CENTIMETER("recipee.metric.centimeter"),
	NONE("recipee.metric.none");

	private String name;

	private Metric(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
