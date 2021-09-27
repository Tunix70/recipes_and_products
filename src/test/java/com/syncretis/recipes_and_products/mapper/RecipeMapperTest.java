package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.domain.Recipe;
import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularRecipeDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RecipeMapperTest {
    RecipeMapper mapper = new RecipeMapper();

    @Test
    void shouldReturnListOfRecipeDomain() {
        //GIVEN
        Recipe domain1 = getRecipeDomain1();
        Recipe domain2 = getRecipeDomain2();
        List<Recipe> expected = List.of(domain1, domain2);

        SpoonacularRecipeDto result1 = getResultResponse1();
        SpoonacularRecipeDto result2 = getResultResponse2();
        List<SpoonacularRecipeDto> resultList = List.of(result1, result2);
        SpoonacularListOfRecipeDto spoonacularListOfRecipeDto = new SpoonacularListOfRecipeDto(resultList);
        //WHEN
        List<Recipe> actual = mapper.mapRecipeResponseToRecipeDomain(spoonacularListOfRecipeDto);
        //THEN
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void shouldReturnListOfRecipeDto() {
        //GIVEN
        RecipeDto result1 = getRecipeDto1();
        RecipeDto result2 = getRecipeDto2();
        List<RecipeDto> expected = List.of(result1, result2);

        Recipe recipeDto1 = getRecipeDomain1();
        Recipe recipeDto2 = getRecipeDomain2();
        List<Recipe> recipes = List.of(recipeDto1, recipeDto2);
        //WHEN
        List<RecipeDto> actual = mapper.mapRecipeDomainToRecipeDto(recipes);
        //THEN
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.size()).isEqualTo(2);
    }

    private Recipe getRecipeDomain1() {
        return new Recipe
                (1, "name1", true, false);
    }

    private Recipe getRecipeDomain2() {
        return new Recipe
                (2, "name2", false, true);
    }

    private SpoonacularRecipeDto getResultResponse1() {
        return new SpoonacularRecipeDto(1, "name1", true, false);
    }

    private SpoonacularRecipeDto getResultResponse2() {
        return new SpoonacularRecipeDto(2, "name2", false, true);
    }

    private RecipeDto getRecipeDto1() {
        return new RecipeDto
                ( "name1", true, false);
    }

    private RecipeDto getRecipeDto2() {
        return new RecipeDto
                ( "name2", false, true);
    }
}