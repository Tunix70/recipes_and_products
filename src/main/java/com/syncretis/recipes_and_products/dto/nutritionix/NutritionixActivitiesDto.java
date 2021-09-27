package com.syncretis.recipes_and_products.dto.nutritionix;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritionixActivitiesDto {
    @JsonProperty(value = "exercises")
    private NutritionixActivityDto[] activities;

    public NutritionixActivitiesDto() {
    }

    public NutritionixActivitiesDto(NutritionixActivityDto[] activities) {
        this.activities = activities;
    }

    public NutritionixActivityDto[] getActivities() {
        return activities;
    }

    public void setActivities(NutritionixActivityDto[] activities) {
        this.activities = activities;
    }
}