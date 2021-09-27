package com.syncretis.recipes_and_products.service.spoonacular;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UrlBuilder {
    @Value("${spoonacular.api-key}")
    private String apiKey;

    // TODO: 26.08.2021 change amount of ingredients in request
    public String buildUrlForAutocompleteIngredientSearch(String subName) {
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://api.spoonacular.com")
                .pathSegment("food")
                .pathSegment("ingredients")
                .pathSegment("autocomplete")
                .queryParam("query", subName)
                .queryParam("apiKey", apiKey)
                .queryParam("number", 2)
                .build();
        return uri.toUriString();
    }

    public String buildUrlForParseIngredientsSearch() {
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://api.spoonacular.com")
                .pathSegment("recipes")
                .pathSegment("parseIngredients")
                .queryParam("includeNutrition", true)
                .queryParam("apiKey", apiKey)
                .build();
        return uri.toString();
    }

    //TODO 09.09.2021 change amount of recipes in request
    public String buildUrlForRecipeSearchBySubstring(String subName) {
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://api.spoonacular.com")
                .pathSegment("recipes")
                .pathSegment("complexSearch")
                .queryParam("query", subName)
                .queryParam("addRecipeInformation", true)
                .queryParam("apiKey", apiKey)
                .queryParam("number", 5)
                .build();
        return uri.toUriString();
    }
}