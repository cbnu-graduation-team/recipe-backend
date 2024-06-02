package com.recipe.backend.domain.recipe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeAllResponseDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String description;

    public RecipeAllResponseDTO(Long id, String title, String thumbnail, String description) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
    }
}
