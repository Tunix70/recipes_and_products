package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.entity.UserGoal;
import org.springframework.stereotype.Component;

@Component
public class UserGoalDtoMapper {
    public UserGoalDto mapUserGoalToUserGoalDto(UserGoal userGoal) {
        double goalWeight = userGoal.getGoalWeight();
        double kCalPerDay = userGoal.getKCalPerDay();
        return new UserGoalDto(goalWeight, kCalPerDay);
    }
}