package com.syncretis.recipes_and_products.dto.spoonacular;

public class IngredientResponseDto {
    private String name;
    private NutritionResponseDto nutrition;

    public IngredientResponseDto() {
    }

    public IngredientResponseDto(String name, NutritionResponseDto nutrition) {
        this.name = name;
        this.nutrition = nutrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionResponseDto getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionResponseDto nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return "IngredientDtoResponse{" +
                "name='" + name + '\'' +
                ", nutrition=" + nutrition +
                '}';
    }
}