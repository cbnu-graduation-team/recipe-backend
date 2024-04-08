package com.recipe.backend.domain.recipe.service;

import com.recipe.backend.domain.recipe.domain.Recipe;
import com.recipe.backend.domain.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void saveRecipes(List<Recipe> recipes) {
        // 필요한 경우 Recipe 객체를 엔티티로 변환하는 작업 수행
        recipeRepository.saveAll(recipes);
    }
}

