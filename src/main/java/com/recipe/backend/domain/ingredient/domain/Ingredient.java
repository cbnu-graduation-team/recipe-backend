package com.recipe.backend.domain.ingredient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recipe.backend.domain.inventory.domain.InventoryIngredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    public Ingredient(String name){
        this.name=name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ingredient_id")
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredient")
    private List<InventoryIngredient> inventoryIngredients = new ArrayList<>();
}
