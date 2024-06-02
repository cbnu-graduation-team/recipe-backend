package com.recipe.backend.global.util.recipedata;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {
    private String title;
    private String description;
    private String servings;
    private String time_required;
    private String difficulty;
    private String thumbnail;
    private List<IngredientDTO> ingredients;
    private List<StepDTO> steps;
}
