package com.recipe.backend.domain.inventory.repository;

import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.inventory.domain.Inventory;
import com.recipe.backend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // InventoryRepository 인터페이스
    Optional<Inventory> findByUser(User user);


}