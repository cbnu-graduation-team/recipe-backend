package com.recipe.backend.domain.recipe.domain;

import com.recipe.backend.domain.recipe_ingredient.domain.RecipeIngredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDetailResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private List<RecipeStep> steps;
    private List<RecipeIngredient> ingredients;

    public RecipeDetailResponseDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.thumbnail = recipe.getThumbnail();
    }
}
