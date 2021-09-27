package com.syncretis.recipes_and_products.service.nutritionix;

import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {NutritionixService.class},
        initializers = {ConfigDataApplicationContextInitializer.class})
@TestPropertySource(properties = {"spring.config.location=classpath:application.yml"})
class NutritionixServiceTest {
    @MockBean
    private NutritionixUrlBuilder urlBuilder;
    @MockBean
    private RestTemplate restTemplate;
    @Autowired
    private NutritionixService service;

    @Test
    void shouldReturnExercise() {
        //GIVEN
        NutritionixActivityDto exerciseDto = new NutritionixActivityDto("running", 11.43, 1);
        NutritionixActivityDto[] arrayOfExercises = new NutritionixActivityDto[1];
        arrayOfExercises[0] = exerciseDto;
        NutritionixActivitiesDto expected = new NutritionixActivitiesDto(arrayOfExercises);

        given(urlBuilder.buildPostRequestUrl()).willReturn("url");
        given(restTemplate.postForObject(anyString(), any(), any())).willReturn(expected);
        //WHEN
        NutritionixActivitiesDto actual = service.getExercise("run");
        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnNullPointerExceptionWhenQueryIsNull() {
        assertThatThrownBy(() -> service.getExercise(null)).isInstanceOf(NullPointerException.class);
    }
}