package com.syncretis.recipes_and_products.dto.rap;

import java.util.Objects;
import java.util.StringJoiner;

public class IngredientDto {
    private String name;
    private double glycemicIndex;
    private NutritionDto nutrition;

    public IngredientDto() {
    }

    public IngredientDto(String name, double glycemicIndex, NutritionDto nutrition) {
        this.name = name;
        this.glycemicIndex = glycemicIndex;
        this.nutrition = nutrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(double glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public NutritionDto getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionDto nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientDto that = (IngredientDto) o;
        return Objects.equals(name, that.name) && Objects.equals(glycemicIndex, that.glycemicIndex)
                && Objects.equals(nutrition, that.nutrition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, glycemicIndex, nutrition);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IngredientDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("glycemicIndex=" + glycemicIndex)
                .add("nutrition=" + nutrition)
                .toString();
    }
}