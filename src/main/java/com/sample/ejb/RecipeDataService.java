package com.sample.ejb;

import java.util.List;

import javax.ejb.Local;

import com.sample.model.Ingredient;
import com.sample.model.Recipe;

@Local
public interface RecipeDataService {

	public Recipe getById(int recipeId);
	public List<Recipe> getWithIngredients(Ingredient[] ingredients);
	public void store(Recipe recipe);
	public void update(Recipe recipe);
	public void delete(Recipe recipe);
	public void deleteByID(int recipeId);
	
}
