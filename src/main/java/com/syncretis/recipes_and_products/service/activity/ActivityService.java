package com.syncretis.recipes_and_products.service.activity;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import com.syncretis.recipes_and_products.mapper.ActivityDtoMapper;
import com.syncretis.recipes_and_products.mapper.ActivityMapper;
import com.syncretis.recipes_and_products.service.nutritionix.NutritionixService;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    private final NutritionixService nutritionixService;
    private final ActivityMapper activityMapper;
    private final ActivityDtoMapper dtoMapper;

    public ActivityService(NutritionixService nutritionixService, ActivityMapper activityMapper, ActivityDtoMapper dtoMapper) {
        this.nutritionixService = nutritionixService;
        this.activityMapper = activityMapper;
        this.dtoMapper = dtoMapper;
    }

    public ActivityDto getActivity(String query) {
        NutritionixActivitiesDto dto = nutritionixService.getExercise(query);
        Activity domainModel = activityMapper.map(dto);
        return dtoMapper.map(domainModel);
    }
}