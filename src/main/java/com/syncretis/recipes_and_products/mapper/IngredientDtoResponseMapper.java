package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.dto.rap.NutritionDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.NutrientsResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.PropertiesResponseDto;
import com.syncretis.recipes_and_products.exception.UnsupportedUnitException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientDtoResponseMapper {
    private double weightCoefficient;

    public List<IngredientDto> mapIngredientDtoResponseList(IngredientResponseDto[] ingredientsResponseDto) {
        List<IngredientDto> ingredientsDto = new ArrayList<>();
        for (IngredientResponseDto ingredientResponseDto : ingredientsResponseDto) {
            ingredientsDto.add(mapIngredientDtoFromResponse(ingredientResponseDto));
        }
        return ingredientsDto;
    }

    private IngredientDto mapIngredientDtoFromResponse(IngredientResponseDto ingredientResponseDto) {
        IngredientDto ingredientDto = new IngredientDto();
        weightCoefficient = getWeightCoefficient(ingredientResponseDto.getNutrition().getWeightPerServing().getAmount(),
                ingredientResponseDto.getNutrition().getWeightPerServing().getUnit());

        ingredientDto.setName(ingredientResponseDto.getName());

        for (PropertiesResponseDto property : ingredientResponseDto.getNutrition().getProperties()) {
            if (property.getName().equals("Glycemic Index")) {
                ingredientDto.setGlycemicIndex(property.getAmount());
                break;
            }
        }
        NutritionDto newNutritionDto = new NutritionDto();

        for (NutrientsResponseDto nutrient : ingredientResponseDto.getNutrition().getNutrients()) {
            if (nutrient.getName().equals("Calories")) {
                newNutritionDto.setCalories(calculateNutrition(nutrient.getAmount()));
            } else if (nutrient.getName().equals("Protein")) {
                newNutritionDto.setProtein(calculateNutrition(nutrient.getAmount()));
            } else if (nutrient.getName().equals("Fat")) {
                newNutritionDto.setFat(calculateNutrition(nutrient.getAmount()));
            } else if (nutrient.getName().equals("Carbohydrates")) {
                newNutritionDto.setCarbohydrates(calculateNutrition(nutrient.getAmount()));
            }
        }
        ingredientDto.setNutrition(newNutritionDto);
        return ingredientDto;
    }

    private double getWeightCoefficient(long weight, String unit) {
        if (unit.equals("g")) {
            return (BigDecimal.valueOf(weight).divide(BigDecimal.valueOf(100.0), 16, RoundingMode.HALF_UP)).doubleValue();
        } else {
            throw new UnsupportedUnitException(unit);
        }
    }

    private double calculateNutrition(double nutritionAmount) {
        return (BigDecimal.valueOf(nutritionAmount).divide(BigDecimal.valueOf(weightCoefficient), 16, RoundingMode.HALF_UP).doubleValue());
    }
}