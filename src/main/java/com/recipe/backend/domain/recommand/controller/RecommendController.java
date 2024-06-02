package com.recipe.backend.domain.recommand.controller;

import com.recipe.backend.domain.inventory.dto.IngredientsRequest;
import com.recipe.backend.domain.recommand.domain.RecommendationResponseDTO;
import com.recipe.backend.domain.recommand.service.RecommendService;
import com.recipe.backend.global.config.auth.JwtUtil;
import com.recipe.backend.global.response.ApiResponse;
import com.recipe.backend.global.response.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommend")
public class RecommendController {
    private final RecommendService recommendService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<List<RecommendationResponseDTO>>> recommendRecipes(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.getUserNameFromJwtToken(token);
        List<RecommendationResponseDTO> recommendations = recommendService.recommendRecipe(username);
        return ApiResponse.success(SuccessMessages.RECOM_SUCCESS, recommendations);
    }
}
