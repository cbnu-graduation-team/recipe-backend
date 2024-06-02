package com.recipe.backend.domain.recipe.controller;

import com.recipe.backend.domain.recipe.domain.RecipeAllResponseDTO;
import com.recipe.backend.domain.recipe.domain.RecipeDetailResponseDTO;
import com.recipe.backend.domain.recipe.service.RecipeService;
import com.recipe.backend.global.response.ApiResponse;
import com.recipe.backend.global.response.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<RecipeAllResponseDTO>>> getRecipes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<RecipeAllResponseDTO> recipes = recipeService.getRecipes(page, size);
        return ApiResponse.success(SuccessMessages.LOAD_RECIPE_SUCCESS,recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RecipeDetailResponseDTO>> getRecipeDetail(@PathVariable Long id){
        RecipeDetailResponseDTO recipeDetail = recipeService.getRecipeById(id);
        return ApiResponse.success(SuccessMessages.LOAD_RECIPE_DETAIL_SUCCESS, recipeDetail);
    }
}
