package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivityDto;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {
    public Activity map(NutritionixActivitiesDto dto) {
        NutritionixActivityDto exercise = dto.getActivities()[0];
        Activity activity = new Activity();
        activity.setName(exercise.getName());
        activity.setBurntCalories(exercise.getBurntCalories());
        activity.setDurationInMinutes(exercise.getDurationMin());
        return activity;
    }
}