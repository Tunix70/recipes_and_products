package com.syncretis.recipes_and_products.util;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.dto.rap.NutritionDto;

import java.util.List;

public class RapIngredientDtos {
    public static List<IngredientDto> getSomeIngredientList(double glycemicIndex, double calories, double protein,
                                                            double fat, double carbohydrates, double coefficient) {
        return List.of(
                new IngredientDto("name1", glycemicIndex, getNutritionDto(calories, protein, fat, carbohydrates)),
                new IngredientDto("name2", glycemicIndex + coefficient,
                        getNutritionDto(calories + coefficient, protein + coefficient, fat + coefficient, carbohydrates + coefficient)));
    }

    private static NutritionDto getNutritionDto(double calories, double protein, double fat, double carbohydrates) {
        return new NutritionDto(calories, protein, fat, carbohydrates);
    }
}