package com.syncretis.recipes_and_products.util;

import com.syncretis.recipes_and_products.dto.spoonacular.*;

import java.util.List;

public class SpoonacularIngredientDtos {
    public static IngredientResponseDto[] getSomeIngredientResponseDto() {
        return new IngredientResponseDto[]{
                getIngredientResponseDto1(),
                getIngredientResponseDto2()};
    }

    private static IngredientResponseDto getIngredientResponseDto1() {
        NutrientsResponseDto nutrient1 = new NutrientsResponseDto("Calories", 1.1, "g");
        NutrientsResponseDto nutrient2 = new NutrientsResponseDto("Protein", 1.2, "g");
        NutrientsResponseDto nutrient3 = new NutrientsResponseDto("Fat", 1.3, "g");
        NutrientsResponseDto nutrient4 = new NutrientsResponseDto("Carbohydrates", 1.4, "g");
        List<NutrientsResponseDto> nutrientsList1 = List.of(nutrient1, nutrient2, nutrient3, nutrient4);

        PropertiesResponseDto property1 = new PropertiesResponseDto("Glycemic Index", 2.1);
        List<PropertiesResponseDto> propertiesList1 = List.of(property1);

        WeightPerServingResponseDto weightPerServing1 = new WeightPerServingResponseDto(1, "g");

        NutritionResponseDto nutritionResponseDto = new NutritionResponseDto(nutrientsList1, propertiesList1, weightPerServing1);
        return new IngredientResponseDto("ingredient1", nutritionResponseDto);
    }

    private static IngredientResponseDto getIngredientResponseDto2() {
        NutrientsResponseDto nutrient5 = new NutrientsResponseDto("Calories", 2.1, "g");
        NutrientsResponseDto nutrient6 = new NutrientsResponseDto("Protein", 2.2, "g");
        NutrientsResponseDto nutrient7 = new NutrientsResponseDto("Fat", 2.3, "g");
        NutrientsResponseDto nutrient8 = new NutrientsResponseDto("Carbohydrates", 2.4, "g");
        List<NutrientsResponseDto> nutrientsList2 = List.of(nutrient5, nutrient6, nutrient7, nutrient8);

        PropertiesResponseDto property2 = new PropertiesResponseDto("Glycemic Index", 2.3);
        List<PropertiesResponseDto> propertiesList2 = List.of(property2);

        WeightPerServingResponseDto weightPerServing2 = new WeightPerServingResponseDto(2, "g");

        NutritionResponseDto nutritionResponseDto = new NutritionResponseDto(nutrientsList2, propertiesList2, weightPerServing2);
        return new IngredientResponseDto("ingredient2", nutritionResponseDto);
    }

    public static IngredientNameResponseDto[] getSomeIngredientNameResponseDtos() {
        return new IngredientNameResponseDto[]{
                new IngredientNameResponseDto("name1"),
                new IngredientNameResponseDto("name1")};
    }
}
