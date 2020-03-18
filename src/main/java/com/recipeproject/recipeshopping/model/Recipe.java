package com.recipeproject.recipeshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipies")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "recipe_name", nullable = false)
	private String name;

	@Column(name = "recipe_description")
	private String description;

	@Column(name = "image_path")
	private String imagePath;

	public Recipe() {

	}

	public Recipe(String name, String description, String imagePath) {
		super();
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Recipe [id= " + id + ", name= " + name + ", desc= " + description + ", imagePath=" + imagePath + "]";

	}

}
