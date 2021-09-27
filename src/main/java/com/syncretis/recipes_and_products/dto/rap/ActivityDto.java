package com.syncretis.recipes_and_products.dto.rap;

import java.util.Objects;

public class ActivityDto {
    private String name;
    private double burntCalories;

    public ActivityDto() {
    }

    public ActivityDto(String name, double burntCalories) {
        this.name = name;
        this.burntCalories = burntCalories;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityDto dto = (ActivityDto) o;
        return Double.compare(dto.burntCalories, burntCalories) == 0 &&
                name.equals(dto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, burntCalories);
    }

    @Override
    public String toString() {
        return "ActivityDto{" +
                "name='" + name + '\'' +
                ", burntCalories=" + burntCalories +
                '}';
    }
}