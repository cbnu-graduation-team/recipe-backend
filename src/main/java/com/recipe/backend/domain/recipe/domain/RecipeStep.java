package com.recipe.backend.domain.recipe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stepNumber;
    private String description;
    private String image;

    @ManyToOne
    private Recipe recipe; // 해당 단계가 속한 레시피

    // 생성자, Getter, Setter 생략
}
