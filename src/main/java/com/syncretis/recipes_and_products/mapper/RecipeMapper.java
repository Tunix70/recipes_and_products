package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.domain.Recipe;
import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularRecipeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeMapper {
    public List<Recipe> mapRecipeResponseToRecipeDomain(SpoonacularListOfRecipeDto spoonacularListOfRecipeDto) {
        List<Recipe> recipeDto = new ArrayList<>();
        for (SpoonacularRecipeDto resultRecipe : spoonacularListOfRecipeDto.getResults()) {
            Recipe dto = new Recipe();
            dto.setId(resultRecipe.getId());
            dto.setName(resultRecipe.getTitle());
            dto.setGlutenFree(resultRecipe.isGlutenFree());
            dto.setDairyFree(resultRecipe.isDairyFree());

            recipeDto.add(dto);
        }
        return recipeDto;
    }

    public List<RecipeDto> mapRecipeDomainToRecipeDto(List<Recipe> recipes) {
        List<RecipeDto> recipeDto = new ArrayList<>();
        for (Recipe domain : recipes) {
            RecipeDto dto = new RecipeDto();
            dto.setName(domain.getName());
            dto.setGlutenFree(domain.isGlutenFree());
            dto.setDairyFree(domain.isDairyFree());

            recipeDto.add(dto);
        }
        return recipeDto;
    }
}
