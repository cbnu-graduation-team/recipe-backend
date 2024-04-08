package com.recipe.backend.domain.rating.domain;

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
public class RecipeRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private Integer rating;
    private String comment;
    private LocalDateTime ratingDate;
}
