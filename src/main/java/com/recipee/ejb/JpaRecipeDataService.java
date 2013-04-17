package com.recipee.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.recipee.model.Ingredient;
import com.recipee.model.Recipe;

@Stateless
@LocalBean
public class JpaRecipeDataService implements GenericDataService<Recipe> {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@PersistenceContext(unitName = "recipePU")
	private EntityManager entityManager;

	public Recipe getById(int recipeId) {
		return entityManager.find(Recipe.class, recipeId);
	}

	public List<Recipe> getWithIngredients(Ingredient[] ingredients) {
		Query withIngredientsQuery = entityManager
				.createNamedQuery("Recipe.withIngredients");
		for (Ingredient ingredient : ingredients) {
			withIngredientsQuery.setParameter("ingreds", ingredient.getLabel());
		}
		List<Recipe> recipes = withIngredientsQuery.getResultList();
		log.debug("{} recipes with the ingredients ({}) found.", recipes.size(), ingredients);
		return null;
	}

	public void store(Recipe recipe) {
		entityManager.persist(recipe);
		entityManager.flush();
	}

	public void update(Recipe recipe) {
		entityManager.merge(recipe);
	}

	public void delete(Recipe recipe) {
		Recipe recipeToRemove = recipe;
		if (!entityManager.contains(recipe)) {
			recipeToRemove = entityManager.merge(recipe);
		}
		entityManager.remove(recipeToRemove);

	}

	public void deleteByID(int recipeId) {
		delete(getById(recipeId));

	}

	public List<Recipe> getAll() {
		return entityManager.createQuery("SELECT r FROM Recipe r").getResultList();
	}

}
