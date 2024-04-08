package com.recipe.backend.domain.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IngredientResponseDTO {
    private String name;
    private LocalDate expiryDate;

    public IngredientResponseDTO(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

