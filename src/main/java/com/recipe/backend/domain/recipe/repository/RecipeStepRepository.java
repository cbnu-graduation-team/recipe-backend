package com.recipe.backend.domain.recipe.repository;

import com.recipe.backend.domain.recipe.domain.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Long> {
    List<RecipeStep> findByRecipeId(Long recipeId);
}
