package com.recipee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public @Data class Review {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(optional = false, fetch=FetchType.LAZY)
	@JoinColumn
	private Recipe recipe;
	
	@Enumerated
	private Rating ratingStars;
	
	@Column
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime ratingDate;
	
	@Column
	private String reviewText;

}
