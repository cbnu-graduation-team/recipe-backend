//package com.recipe.backend;
//
//import com.recipe.backend.domain.recipe.domain.Recipe;
//import com.recipe.backend.domain.recipe.service.RecipeService;
//import com.recipe.backend.global.util.recipedata.RecipeJsonReader;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.io.IOException;
//import java.util.List;
//
//@SpringBootTest
//public class RecipeJsonReaderTest {
//
//    @Autowired
//    private RecipeService recipeService;
//
//    @Test
//    public void testReadRecipesFromFileAndSave() throws IOException {
//        // JSON 파일 경로
//        String filePath = "src/test/resources/recipes.json";
//
//        // RecipeJsonReader 객체 생성
//        RecipeJsonReader reader = new RecipeJsonReader();
//
//        // JSON 파일에서 레시피 읽기
//        List<Recipe> recipes = reader.readRecipesFromFile(filePath);
//
//        // 레시피 데이터베이스에 저장
//        recipeService.saveRecipes(recipes);
//
//        // 저장된 레시피 수 검증 등의 추가적인 테스트 코드를 작성할 수 있습니다.
//    }
//}
//
