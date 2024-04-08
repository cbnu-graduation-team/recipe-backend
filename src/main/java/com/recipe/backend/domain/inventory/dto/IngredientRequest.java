package com.recipe.backend.domain.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IngredientRequest {
    String name;
    private LocalDate expiryDate;
}
