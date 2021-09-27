package com.syncretis.recipes_and_products.service.recipe;

import com.syncretis.recipes_and_products.dto.domain.Recipe;
import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;
import com.syncretis.recipes_and_products.mapper.RecipeMapper;
import com.syncretis.recipes_and_products.service.spoonacular.SpoonacularService;
import com.syncretis.recipes_and_products.util.SpoonacularRecipeDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
    private final String SUBNAME = "soup";

    @Mock
    private RecipeMapper recipeMapper;
    @Mock
    private SpoonacularService spoonacularService;
    @InjectMocks
    private RecipeService recipeService;

    @Test
    void shouldReturnRecipeDtoList() {
        //GIVEN

        SpoonacularListOfRecipeDto responseDto = SpoonacularRecipeDtos.getSomeResultSearchRecipeDto();
        List<Recipe> recipes = SpoonacularRecipeDtos.getSomeListRecipeDomains();
        List<RecipeDto> expected = SpoonacularRecipeDtos.getSomeListRecipeDto();

        given(spoonacularService.getRecipeResponseDto(SUBNAME)).willReturn(responseDto);
        given(recipeMapper.mapRecipeResponseToRecipeDomain(responseDto)).willReturn(recipes);
        given(recipeMapper.mapRecipeDomainToRecipeDto(recipes)).willReturn(expected);

        //WHEN
        List<RecipeDto> actual = recipeService.getRecipes(SUBNAME);
        //THEN
        assertThat(actual).isEqualTo(expected);
    }
}