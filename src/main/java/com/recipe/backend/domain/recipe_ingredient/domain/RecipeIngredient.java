package com.recipe.backend.domain.recipe_ingredient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.recipe.domain.Recipe;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredient_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

}
