package com.recipe.backend.domain.inventory.controller;// InventoryController.java

import com.recipe.backend.domain.inventory.dto.IngredientResponseDTO;
import com.recipe.backend.domain.inventory.dto.IngredientsRequest;
import com.recipe.backend.domain.inventory.service.InventoryService;
import com.recipe.backend.global.config.auth.JwtUtil;
import com.recipe.backend.global.response.ApiResponse;
import com.recipe.backend.global.response.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    private final JwtUtil jwtUtil;

    @PostMapping("/ingredients/add")
    public ResponseEntity<ApiResponse<String>> addIngredients(@RequestBody IngredientsRequest ingredientsRequest,
                                                      @RequestHeader("Authorization") String token) {
        String name = jwtUtil.getUserNameFromJwtToken(token);
        inventoryService.addIngredientsToInventory(ingredientsRequest,name);
        return ApiResponse.success(SuccessMessages.ADD_INGRE_SUCCESS);
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<IngredientResponseDTO>>> getUserInventory(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.getUserNameFromJwtToken(token);
        List<IngredientResponseDTO> inventory = inventoryService.getUserInventoryIngredients(username);
        return ApiResponse.success(SuccessMessages.LOAD_INVENTORY, inventory);
    }

}
