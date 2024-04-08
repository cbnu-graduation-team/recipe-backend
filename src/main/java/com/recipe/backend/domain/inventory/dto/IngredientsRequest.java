package com.recipe.backend.domain.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class IngredientsRequest {

    private List<IngredientRequest> ingredients;
}

