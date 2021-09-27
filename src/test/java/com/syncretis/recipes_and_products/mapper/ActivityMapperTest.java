package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivityDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ActivityMapperTest {
    private final ActivityMapper mapper = new ActivityMapper();

    @Test
    void shouldCorrectMapNutritionixActivityDtoToActivityDomain() {
        //GIVEN
        NutritionixActivityDto running = new NutritionixActivityDto("running", 11.43, 1);
        NutritionixActivityDto[] arrayOfActivities = new NutritionixActivityDto[]{running};
        NutritionixActivitiesDto arrayOfDto = new NutritionixActivitiesDto(arrayOfActivities);

        Activity expected = new Activity("running", 11.43, 1);
        //WHEN
        Activity actual = mapper.map(arrayOfDto);
        //THEN
        assertThat(actual).isEqualTo(expected);

    }
}