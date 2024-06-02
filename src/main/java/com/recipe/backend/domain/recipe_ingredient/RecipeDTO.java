package com.recipe.backend.domain.recipe_ingredient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {
    public String thumbnail;
    public String title;
    public String description;
    public List<IngredientDTO> ingredients;
    public List<RecipeStepDTO> steps;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IngredientDTO {
        public String name;
    }

    public static class RecipeStepDTO {
        @JsonProperty("step_number")
        public int stepNumber;
        public String description;
        public String image;
    }
}

