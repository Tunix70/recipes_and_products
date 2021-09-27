package com.syncretis.recipes_and_products.service.activity;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivityDto;
import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import com.syncretis.recipes_and_products.mapper.ActivityDtoMapper;
import com.syncretis.recipes_and_products.mapper.ActivityMapper;
import com.syncretis.recipes_and_products.service.nutritionix.NutritionixService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {
    @Mock
    NutritionixService nutritionixService;
    @Mock
    private ActivityMapper domainModelMapper;
    @Mock
    private ActivityDtoMapper dtoMapper;
    @InjectMocks
    ActivityService service;

    private Activity domainModel;
    private NutritionixActivitiesDto nutritionixActivitiesDto;

    @Test
    void shouldReturnActivityByName() {
        //GIVEN
        setData();
        ActivityDto expected = new ActivityDto("running", 11.43);

        given(nutritionixService.getExercise(anyString())).willReturn(nutritionixActivitiesDto);
        given(domainModelMapper.map(any())).willReturn(domainModel);
        given(dtoMapper.map(any())).willReturn(expected);
        //WHEN
        ActivityDto actual = service.getActivity("run");
        //THEN
        verify(nutritionixService).getExercise(anyString());
        verify(domainModelMapper).map(any());
        verify(dtoMapper).map(any());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnNullWhenQueryIsNull() {
        //WHEN
        ActivityDto actual = service.getActivity(null);
        //THEN
        assertThat(actual).isNull();
    }

    @Test
    void shouldReturnNullWhenNutritionixServiceReturnNull() {
        //GIVEN
        given(nutritionixService.getExercise(anyString())).willReturn(null);
        //WHEN
        ActivityDto actual = service.getActivity("run");
        //WHEN
        verify(nutritionixService).getExercise(anyString());
        assertThat(actual).isEqualTo(null);
    }

    @Test
    void shouldReturnNullWhenDomainMapperReturnNull() {
        //GIVEN
        given(domainModelMapper.map(any())).willReturn(null);
        //WHEN
        ActivityDto actual = service.getActivity("run");
        //THEN
        verify(domainModelMapper).map(any());
        assertThat(actual).isEqualTo(null);
    }

    @Test
    void shouldReturnNullWhenDtoMapperReturnNull() {
        //GIVEN
        given(dtoMapper.map(any())).willReturn(null);
        //WHEN
        ActivityDto actual = service.getActivity("run");
        //THEN
        verify(dtoMapper).map(any());
        assertThat(actual).isEqualTo(null);
    }

    private void setData() {
        NutritionixActivityDto[] nutritionixActivityDtos = new NutritionixActivityDto[1];
        nutritionixActivityDtos[0] = new NutritionixActivityDto();
        nutritionixActivityDtos[0].setName("running");
        nutritionixActivityDtos[0].setBurntCalories(11.43);
        nutritionixActivityDtos[0].setDurationMin(1);
        domainModel = new Activity(
                nutritionixActivityDtos[0].getName(),
                nutritionixActivityDtos[0].getBurntCalories(),
                nutritionixActivityDtos[0].getDurationMin());
        nutritionixActivitiesDto = new NutritionixActivitiesDto(nutritionixActivityDtos);
    }
}