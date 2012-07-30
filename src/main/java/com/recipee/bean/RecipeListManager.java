package com.recipee.bean;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.recipee.ejb.JpaRecipeDataService;
import com.recipee.model.Ingredient;
import com.recipee.model.Metric;
import com.recipee.model.Recipe;

@ManagedBean(name = "recipeList")
@SessionScoped
public class RecipeListManager {
	
	private List<Recipe> recipeList;
	
	@EJB
	private JpaRecipeDataService recipeDataService;

	public void load() {
		// TESTING
		saveDummyData();
		// TESTING
		
		System.out.println("loaaaading...");
		recipeList = recipeDataService.getAll();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("Successful loading!", recipeList.size() + " are available.."));

	}

	private void saveDummyData() {
		Recipe recipe = new Recipe();
		recipe.setLabelName("Türkische Spinat-Eierpfanne");
		recipe.setPicId("avfzz52qs2");
		recipe.setShortDescription("Herzhaft-würziges Pfannengericht");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setLabel("mildes Ajvar");
		ingredient.setMetric(Metric.TABLESPOON);
		ingredient.setMetricValue("2");
		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setLabel("Kichererbsen");
		ingredient1.setMetric(Metric.GRAM);
		ingredient1.setMetricValue("200");
		
		recipe.setIngredients(Arrays.asList(ingredient, ingredient1));
		
		Recipe recipe1 = new Recipe();
		recipe1.setLabelName("Vegetarische Ofenpizza");
		recipe1.setPicId("avfe211zfe2");
		recipe1.setShortDescription("Wie aus dem Steinofen...");
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setLabel("Lauch");
		ingredient2.setMetric(Metric.PIECE);
		ingredient2.setMetricValue("1");
		
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setLabel("Spinat");
		ingredient3.setMetric(Metric.KILOGRAM);
		ingredient3.setMetricValue("1/2");
		
		recipe1.setIngredients(Arrays.asList(ingredient2, ingredient3));
		
		System.out.println("Try to persist");
		
		recipeDataService.store(recipe);
		recipeDataService.store(recipe1);
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
}
