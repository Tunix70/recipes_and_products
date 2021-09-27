package com.syncretis.recipes_and_products.service.nutritionix;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NutritionixUrlBuilderTest {
    private final NutritionixUrlBuilder urlBuilder = new NutritionixUrlBuilder();

    @Test
    void shouldCorrectBuildUrl() {
        //GIVEN
        String expected = "https://trackapi.nutritionix.com/v2/natural/exercise";
        //WHEN
        String actual = urlBuilder.buildPostRequestUrl();
        //THEN
        assertThat(actual).isEqualTo(expected);
    }
}