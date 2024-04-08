package com.recipe.backend.global.util.recipedata;

import com.recipe.backend.domain.recipe.domain.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeJson {
    private List<Recipe> recipes;
}
