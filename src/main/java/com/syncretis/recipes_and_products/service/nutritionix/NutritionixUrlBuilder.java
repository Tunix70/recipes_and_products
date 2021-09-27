package com.syncretis.recipes_and_products.service.nutritionix;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NutritionixUrlBuilder {
    public String buildPostRequestUrl() {
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://trackapi.nutritionix.com")
                .pathSegment("v2")
                .pathSegment("natural")
                .pathSegment("exercise")
                .build();
        return uri.toString();
    }
}