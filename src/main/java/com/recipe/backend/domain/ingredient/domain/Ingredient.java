package com.recipe.backend.domain.ingredient.domain;

import com.recipe.backend.domain.recipe.domain.Recipe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String quantity; // 단위를 포함한 수량 정보 (예: "1/2개", "1/3모")

    @ManyToOne
    private Recipe recipe; // 해당 재료가 속한 레시피

    // 생성자, Getter, Setter 생략
}
