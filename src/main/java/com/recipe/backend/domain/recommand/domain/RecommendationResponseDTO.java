package com.recipe.backend.domain.recommand.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RecommendationResponseDTO {
    private Long recipeId;
    private String title;
    private String description;
    private String thumbnail;
    private List<String> ingredients;
    private List<String> steps;
}
