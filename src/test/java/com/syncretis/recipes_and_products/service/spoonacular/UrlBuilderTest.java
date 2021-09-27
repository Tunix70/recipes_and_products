package com.syncretis.recipes_and_products.service.spoonacular;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {UrlBuilder.class},
        initializers = {ConfigDataApplicationContextInitializer.class})
@TestPropertySource(properties = {"spring.config.location=classpath:application.yml"})
class UrlBuilderTest {
    private final String SOMESTRING = "app";
    @Autowired
    private UrlBuilder urlBuilder;

    @Value("${spoonacular.api-key}")
    private String apiKey;

    @Test
    void buildGetAutocompleteSearchUrl() {
        //GIVEN
        String expected = "https://api.spoonacular.com/food/ingredients/autocomplete?query=app&apiKey=" + apiKey + "&number=2";
        //WHEN
        String actual = urlBuilder.buildUrlForAutocompleteIngredientSearch("app");
        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void buildPostParseIngredientsUrl() {
        //GIVEN
        String expected = "https://api.spoonacular.com/recipes/parseIngredients?includeNutrition=true&apiKey=" + apiKey;
        //WHEN
        String actual = urlBuilder.buildUrlForParseIngredientsSearch();
        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnRecipeSearchBySubstringUrl() {
        //GIVEN
        String expected = "https://api.spoonacular.com/recipes/complexSearch?query=" + SOMESTRING
                + "&addRecipeInformation=true&apiKey=" + apiKey + "&number=5";
        //WHEN
        String actual = urlBuilder.buildUrlForRecipeSearchBySubstring(SOMESTRING);
        //THEN
        assertThat(actual).isEqualTo(expected);
    }
}