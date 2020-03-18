package com.recipeproject.recipeshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipeproject.recipeshopping.exception.ResourceNotFoundException;
import com.recipeproject.recipeshopping.model.Recipe;
import com.recipeproject.recipeshopping.repository.RecipeRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")

public class RecipeController {

	Recipe recipe;

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping(value = "/recipes")
	public List<Recipe> getRecipes() {
		return this.recipeRepository.findAll();

	}

	@PostMapping(value = "/saveRecipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		this.recipeRepository.save(recipe);
		return new ResponseEntity<Recipe>(HttpStatus.OK);

	}
	
	@GetMapping(value = "/getDetails/{id}")
	public ResponseEntity<Recipe> getRecipeDetails(@PathVariable("id") Long recipeId) throws ResourceNotFoundException {

		recipe = this.recipeRepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe not found for this id :: " + recipeId));
		return ResponseEntity.ok().body(recipe);

	}
	
	
	
	

}
