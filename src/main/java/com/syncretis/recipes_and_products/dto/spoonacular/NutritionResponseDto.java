package com.syncretis.recipes_and_products.dto.spoonacular;

import java.util.List;

public class NutritionResponseDto {
    private List<NutrientsResponseDto> nutrients;
    private List<PropertiesResponseDto> properties;
    private WeightPerServingResponseDto weightPerServing;

    public NutritionResponseDto() {
    }

    public NutritionResponseDto(List<NutrientsResponseDto> nutrients, List<PropertiesResponseDto> properties,
                                WeightPerServingResponseDto weightPerServing) {
        this.nutrients = nutrients;
        this.properties = properties;
        this.weightPerServing = weightPerServing;
    }

    public List<NutrientsResponseDto> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<NutrientsResponseDto> nutrients) {
        this.nutrients = nutrients;
    }

    public List<PropertiesResponseDto> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertiesResponseDto> properties) {
        this.properties = properties;
    }

    public WeightPerServingResponseDto getWeightPerServing() {
        return weightPerServing;
    }

    public void setWeightPerServing(WeightPerServingResponseDto weightPerServing) {
        this.weightPerServing = weightPerServing;
    }

    @Override
    public String toString() {
        return "NutritionDtoResponse{" +
                "nutrients=" + nutrients +
                ", properties=" + properties +
                '}';
    }
}