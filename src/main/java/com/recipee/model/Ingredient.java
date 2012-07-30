package com.recipee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data
class Ingredient {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String label;

	@Column
	private String metricValue;

	@Enumerated
	@Column
	private Metric metric;

	@Override
	public String toString() {
		return metricValue + " " + metric + " " + label;
	}

}
