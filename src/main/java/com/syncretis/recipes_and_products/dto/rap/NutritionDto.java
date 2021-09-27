package com.syncretis.recipes_and_products.dto.rap;

import java.util.Objects;

public class NutritionDto {
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    public NutritionDto() {
    }

    public NutritionDto(double calories, double protein, double fat, double carbohydrates) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionDto that = (NutritionDto) o;
        return Objects.equals(calories, that.calories) && Objects.equals(protein, that.protein)
                && Objects.equals(fat, that.fat) && Objects.equals(carbohydrates, that.carbohydrates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories, protein, fat, carbohydrates);
    }

    @Override
    public String toString() {
        return "NutritionDto{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}