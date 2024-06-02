package com.recipe.backend.domain.recommand.service;

import com.recipe.backend.domain.inventory.domain.Inventory;
import com.recipe.backend.domain.inventory.repository.InventoryRepository;
import com.recipe.backend.domain.recipe.domain.Recipe;
import com.recipe.backend.domain.recipe.repository.RecipeRepository;
import com.recipe.backend.domain.recommand.domain.Recommendation;
import com.recipe.backend.domain.recommand.domain.RecommendationResponseDTO;
import com.recipe.backend.domain.recommand.repository.RecommendationRepository;
import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.repository.UserRepository;
import com.recipe.backend.global.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {
    private final RecipeRepository recipeRepository;
    private final InventoryRepository inventoryRepository;
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;

    public List<RecommendationResponseDTO> recommendRecipe(String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage()));
        Inventory inventory = inventoryRepository.findByUser(user).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage()) );
        Set<String> userIngredients = inventory.getInventoryIngredients().stream()
                .map(ii -> ii.getIngredient().getName())
                .collect(Collectors.toSet());

        // 이미 추천받은 레시피 ID 목록 가져오기
        // 이미 추천받은 레시피 ID 목록 가져오기
        Set<Long> alreadyRecommended = recommendationRepository.findByUser(user)
                .map(list -> list.stream()          // Optional이 값을 포함하면, 스트림 생성
                        .map(Recommendation::getId)  // Recommendation 객체에서 ID 추출
                        .collect(Collectors.toSet()))
                .orElseGet(HashSet::new);// ID를


        List<Recipe> allRecipes = recipeRepository.findAll();
        Map<Recipe, Long> recipeScores = new HashMap<>();

        for (Recipe recipe : allRecipes) {
            if (!alreadyRecommended.contains(recipe.getId())) {
                long matchCount = recipe.getRecipeIngredients().stream()
                        .filter(ri -> userIngredients.contains(ri.getIngredient().getName()))
                        .count();
                recipeScores.put(recipe, matchCount);
            }
        }

        // 최대 5개의 레시피 추천
        List<RecommendationResponseDTO> recommendations = recipeScores.entrySet().stream()
                .sorted(Map.Entry.<Recipe, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> mapToDTO(entry.getKey()))
                .collect(Collectors.toList());

        // 추천 이력 저장
        recommendations.forEach(dto -> {
            Recommendation recommendation = new Recommendation();
            recommendation.setUser(user);
            recommendation.setRecipe(recipeRepository.findById(dto.getRecipeId()).orElseThrow());
            recommendation.setRecommendedDate(LocalDateTime.now());
            recommendationRepository.save(recommendation);
        });
        return recommendations;
    }
    private RecommendationResponseDTO mapToDTO(Recipe recipe) {
        return new RecommendationResponseDTO(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                recipe.getThumbnail(),
                recipe.getRecipeIngredients().stream()
                        .map(ri -> ri.getIngredient().getName())
                        .collect(Collectors.toList()),
                recipe.getSteps().stream()
                        .map(step -> step.getDescription())
                        .collect(Collectors.toList())
        );
    }
}
