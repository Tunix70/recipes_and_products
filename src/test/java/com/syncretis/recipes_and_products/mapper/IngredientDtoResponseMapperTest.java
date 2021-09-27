package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.dto.rap.NutritionDto;
import com.syncretis.recipes_and_products.dto.spoonacular.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IngredientDtoResponseMapperTest {
    private final IngredientDtoResponseMapper mapper = new IngredientDtoResponseMapper();

    private final double caloriesAmount = 0.1;
    private final double proteinAmount = 0.2;
    private final double fatAmount = 0.3;
    private final double carbohydratesAmount = 0.4;
    private final double glycemicIndexAmount = 0.5;

    @Test
    void shouldReturnIngredientDtoList() {
        //GIVEN
        IngredientResponseDto[] ingredientsResponseDto = new IngredientResponseDto[2];
        ingredientsResponseDto[0] = getSomeIngredientResponseDto(1);
        NutritionDto nutritionDto1 = getSomeNutritionDto(1);
        ingredientsResponseDto[1] = getSomeIngredientResponseDto(2);
        NutritionDto nutritionDto2 = getSomeNutritionDto(2);

        List<IngredientDto> expected = List.of(
                new IngredientDto("ingredient1", glycemicIndexAmount + 1, nutritionDto1),
                new IngredientDto("ingredient2", glycemicIndexAmount + 2, nutritionDto2)
        );
        //WHEN
        List<IngredientDto> actual = mapper.mapIngredientDtoResponseList(ingredientsResponseDto);
        //THEN
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.size()).isEqualTo(2);
    }

    private IngredientResponseDto getSomeIngredientResponseDto(int coefficient) {
        NutrientsResponseDto calories = new NutrientsResponseDto("Calories", caloriesAmount + coefficient, "g");
        NutrientsResponseDto protein = new NutrientsResponseDto("Protein", proteinAmount + coefficient, "g");
        NutrientsResponseDto fat = new NutrientsResponseDto("Fat", fatAmount + coefficient, "g");
        NutrientsResponseDto carbohydrates = new NutrientsResponseDto("Carbohydrates", carbohydratesAmount + coefficient, "g");
        List<NutrientsResponseDto> nutrients = List.of(calories, protein, fat, carbohydrates);

        PropertiesResponseDto glycemicIndex = new PropertiesResponseDto("Glycemic Index", glycemicIndexAmount + coefficient);
        List<PropertiesResponseDto> properties = List.of(glycemicIndex);

        WeightPerServingResponseDto weightPerServing = new WeightPerServingResponseDto(100, "g");

        NutritionResponseDto nutritionResponseDto = new NutritionResponseDto(nutrients, properties, weightPerServing);
        return new IngredientResponseDto("ingredient" + coefficient, nutritionResponseDto);
    }

    private NutritionDto getSomeNutritionDto(double coefficient) {
        return new NutritionDto(
                caloriesAmount + coefficient, proteinAmount + coefficient, fatAmount + coefficient, carbohydratesAmount + coefficient);
    }
}