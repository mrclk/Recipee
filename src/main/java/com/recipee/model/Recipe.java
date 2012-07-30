package com.recipee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for a Recipe 
 * @author Marcel K.
 *
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data
class Recipe {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String labelName;
	
	@Column
	private String picId;
	
	@Column
	private String shortDescription;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Ingredient> ingredients;
	
	@Column
	private String instruction;

}
