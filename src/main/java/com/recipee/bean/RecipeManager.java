package com.recipee.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;

import com.recipee.ejb.JpaRecipeDataService;
import com.recipee.model.Recipe;

@ManagedBean(name = "recipeView")
@ViewScoped
public class RecipeManager {

	@Getter
	@Setter
	private Recipe recipe;

	@EJB
	private JpaRecipeDataService recipeDataService;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		recipe = recipeDataService.getById(Integer.valueOf(id));
	}

}
