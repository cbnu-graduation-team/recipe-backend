package com.recipe.backend.domain.recipe_ingredient.domain;

import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.recipe.domain.Recipe;
import jakarta.persistence.*;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

}
