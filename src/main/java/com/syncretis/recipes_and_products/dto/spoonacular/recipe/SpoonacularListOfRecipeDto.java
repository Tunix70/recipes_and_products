package com.syncretis.recipes_and_products.dto.spoonacular.recipe;

import java.util.List;

public class SpoonacularListOfRecipeDto {
    private List<SpoonacularRecipeDto> spoonacularRecipeDtos;

    public SpoonacularListOfRecipeDto() {
    }

    public SpoonacularListOfRecipeDto(List<SpoonacularRecipeDto> spoonacularRecipeDtos) {
        this.spoonacularRecipeDtos = spoonacularRecipeDtos;
    }

    public List<SpoonacularRecipeDto> getResults() {
        return spoonacularRecipeDtos;
    }

    public void setResults(List<SpoonacularRecipeDto> spoonacularRecipeDtos) {
        this.spoonacularRecipeDtos = spoonacularRecipeDtos;
    }

    @Override
    public String toString() {
        return "RecipeResponseDto{" +
                "resultOfRecipesSearchDtos=" + spoonacularRecipeDtos +
                '}';
    }
}
