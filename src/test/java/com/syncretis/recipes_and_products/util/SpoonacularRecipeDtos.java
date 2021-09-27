package com.syncretis.recipes_and_products.util;

import com.syncretis.recipes_and_products.dto.domain.Recipe;
import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularRecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;

import java.util.List;

public class SpoonacularRecipeDtos {
    public static SpoonacularListOfRecipeDto getSomeResultSearchRecipeDto() {
        SpoonacularRecipeDto result1 = getResultOfRecipesSearchDto1();
        SpoonacularRecipeDto result2 = getResultOfRecipesSearchDto2();
        return new SpoonacularListOfRecipeDto(List.of(result2, result1));
    }

    private static SpoonacularRecipeDto getResultOfRecipesSearchDto1() {
        return new SpoonacularRecipeDto
                (1, "Soup", false, true);
    }

    private static SpoonacularRecipeDto getResultOfRecipesSearchDto2() {
        return new SpoonacularRecipeDto
                (2, "Super Soup", true, false);
    }

    public static List<Recipe> getSomeListRecipeDomains() {
        Recipe recipe1 = getRecipeDomain1();
        Recipe recipe2 = getRecipeDomain2();
        return List.of(recipe1, recipe2);
    }

    private static Recipe getRecipeDomain1() {
        return new Recipe(1, "Soup", false, true);
    }

    private static Recipe getRecipeDomain2() {
        return new Recipe(2, "Super Soup", true, false);
    }

    public static List<RecipeDto> getSomeListRecipeDto() {
        RecipeDto recipeDto1 = getRecipeDto1();
        RecipeDto recipeDto2 = getRecipeDto2();
        return List.of(recipeDto1, recipeDto2);
    }

    private static RecipeDto getRecipeDto1() {
        return new RecipeDto("Soup", false, true);
    }

    private static RecipeDto getRecipeDto2() {
        return new RecipeDto("Super Soup", true, false);
    }
}
