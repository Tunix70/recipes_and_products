package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import org.springframework.stereotype.Component;

@Component
public class ActivityDtoMapper {
    public ActivityDto map(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setName(activity.getName());
        activityDto.setBurntCalories(activity.getBurntCalories());
        return activityDto;
    }
}