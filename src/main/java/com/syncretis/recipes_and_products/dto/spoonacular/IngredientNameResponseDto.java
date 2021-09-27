package com.syncretis.recipes_and_products.dto.spoonacular;

public class IngredientNameResponseDto {
    private String name;

    public IngredientNameResponseDto() {
    }

    public IngredientNameResponseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IngredientNameResponseDto{" +
                "name='" + name + '\'' +
                '}';
    }
}