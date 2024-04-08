package com.recipe.backend.domain.recipe.domain;

import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.recipe_ingredient.domain.RecipeIngredient;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recipeId")
    private Long id;

    private String title;
    private String description;
    private String thumbnail;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeStep> steps;

}
