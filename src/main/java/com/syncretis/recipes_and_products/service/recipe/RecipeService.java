package com.syncretis.recipes_and_products.service.recipe;

import com.syncretis.recipes_and_products.dto.domain.Recipe;
import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;
import com.syncretis.recipes_and_products.mapper.RecipeMapper;
import com.syncretis.recipes_and_products.service.spoonacular.SpoonacularService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final SpoonacularService spoonacularService;
    private final RecipeMapper recipeMapper;

    public RecipeService(SpoonacularService spoonacularService,
                         RecipeMapper recipeMapper) {
        this.spoonacularService = spoonacularService;
        this.recipeMapper = recipeMapper;
    }

    public List<RecipeDto> getRecipes(String subName) {
        SpoonacularListOfRecipeDto spoonacularListOfRecipeDto =
                spoonacularService.getRecipeResponseDto(subName);
        List<Recipe> domain = recipeMapper
                .mapRecipeResponseToRecipeDomain(spoonacularListOfRecipeDto);
        return recipeMapper.mapRecipeDomainToRecipeDto(domain);
    }
}
