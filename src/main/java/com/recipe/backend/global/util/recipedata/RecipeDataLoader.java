package com.recipe.backend.global.util.recipedata;

import com.recipe.backend.domain.recipe.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class RecipeDataLoader implements CommandLineRunner {

    private final RecipeService recipeService;

    public RecipeDataLoader(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        String jsonFilePath = "C:\\Users\\Mi\\Desktop\\대학자료\\졸업작품\\backend\\src\\main\\resources\\recipes.json"; // JSON 파일 경로
        recipeService.loadAndSaveRecipes(jsonFilePath);
        System.out.println("Recipes loaded and saved successfully.");
    }
}
