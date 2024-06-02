package com.recipe.backend;

import com.recipe.backend.domain.recipe.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class RecipeJsonReaderTest {

    @Autowired
    private RecipeService recipeService;

    @Test
    public void testReadRecipesFromFileAndSave() throws IOException {
        try {
            String jsonFilePath = "C:\\Users\\Mi\\Desktop\\대학자료\\졸업작품\\backend\\src\\main\\resources\\recipes.json"; // JSON 파일 경로
            recipeService.loadAndSaveRecipes(jsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

