package com.recipe.backend.domain.inventory.service;// InventoryService.java
import com.recipe.backend.domain.ingredient.domain.Ingredient;
import com.recipe.backend.domain.ingredient.repository.IngredientRepository;
import com.recipe.backend.domain.inventory.domain.Inventory;
import com.recipe.backend.domain.inventory.dto.IngredientRequest;
import com.recipe.backend.domain.inventory.dto.IngredientResponseDTO;
import com.recipe.backend.domain.inventory.dto.IngredientsRequest;
import com.recipe.backend.domain.inventory.repository.InventoryRepository;
import com.recipe.backend.domain.user.domain.User;
import com.recipe.backend.domain.user.repository.UserRepository;
import com.recipe.backend.global.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    public void addIngredientsToInventory(IngredientsRequest ingredientsRequest,String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage()));// 현재 사용자 조회 로직
        for (IngredientRequest ingredientReq : ingredientsRequest.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientReq.getName())
                    .orElse(new Ingredient(ingredientReq.getName()));
            Inventory inventory = new Inventory();
            inventory.setUser(user);
            inventory.setIngredient(ingredient);
            inventory.setExpiryDate(ingredientReq.getExpiryDate());
            inventoryRepository.save(inventory);
        }
    }
    public List<IngredientResponseDTO> getUserInventoryIngredients(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage()));
        List<Inventory> inventories = inventoryRepository.findByUser(user)
                .orElseThrow(()-> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage()));
        return inventories.stream()
                .map(inventory -> new IngredientResponseDTO((inventory.getIngredient().getName()), inventory.getExpiryDate()))
                .collect(Collectors.toList());
    }

}
