package com.syncretis.recipes_and_products.dto.nutritionix;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class NutritionixActivityDto {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "nf_calories")
    private double burntCalories;
    @JsonProperty(value = "duration_min")
    private double durationMin;

    public NutritionixActivityDto() {
    }

    public NutritionixActivityDto(String name, double burntCalories, double durationMin) {
        this.name = name;
        this.burntCalories = burntCalories;
        this.durationMin = durationMin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBurntCalories() {
        return burntCalories;
    }

    public void setBurntCalories(double burntCalories) {
        this.burntCalories = burntCalories;
    }

    public double getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(double durationMin) {
        this.durationMin = durationMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionixActivityDto that = (NutritionixActivityDto) o;
        return Double.compare(that.burntCalories, burntCalories) == 0 &&
                Double.compare(that.durationMin, durationMin) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, burntCalories, durationMin);
    }

    @Override
    public String toString() {
        return "NutritionixActivityDto{" +
                "name='" + name + '\'' +
                ", burntCalories=" + burntCalories +
                ", durationMin=" + durationMin +
                '}';
    }
}
