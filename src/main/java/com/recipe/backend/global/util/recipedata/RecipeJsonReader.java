package com.recipe.backend.global.util.recipedata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.backend.domain.recipe.domain.Recipe;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecipeJsonReader {
    public List<Recipe> readRecipesFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeJson recipeJson = objectMapper.readValue(new File(filePath), RecipeJson.class);
        return recipeJson.getRecipes();
    }
}
