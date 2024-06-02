package com.recipe.backend.domain.inventory.repository;

import com.recipe.backend.domain.inventory.domain.InventoryIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryIngredientRepository extends JpaRepository<InventoryIngredient, Long> {

}
