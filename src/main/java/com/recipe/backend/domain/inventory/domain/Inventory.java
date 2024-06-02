package com.recipe.backend.domain.inventory.domain;

import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inventory {
    public Inventory(User user){
        this.setUser(user);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "inventory",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InventoryIngredient> inventoryIngredients = new ArrayList<>();
}
