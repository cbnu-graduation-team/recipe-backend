package com.recipe.backend.domain.recommand.domain;

import com.recipe.backend.domain.recipe.domain.Recipe;
import com.recipe.backend.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    private LocalDateTime recommendedDate;
}
