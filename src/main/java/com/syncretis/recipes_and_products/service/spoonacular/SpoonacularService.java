package com.syncretis.recipes_and_products.service.spoonacular;

import com.syncretis.recipes_and_products.dto.spoonacular.IngredientNameResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.recipe.SpoonacularListOfRecipeDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class SpoonacularService {
    private final RestTemplate restTemplate;
    private final UrlBuilder urlBuilder;

    public SpoonacularService(RestTemplate restTemplate, UrlBuilder urlBuilder) {
        this.restTemplate = restTemplate;
        this.urlBuilder = urlBuilder;
    }

    public IngredientNameResponseDto[] getIngredientsNamesBySubName(String subName) {
        String url = urlBuilder.buildUrlForAutocompleteIngredientSearch(subName);
        return restTemplate.getForObject(url, IngredientNameResponseDto[].class);
    }

    public IngredientResponseDto[] getAllInformationOfIngredients(MultiValueMap<String, String> body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(urlBuilder.buildUrlForParseIngredientsSearch(),
                entity, IngredientResponseDto[].class);
    }

    public SpoonacularListOfRecipeDto getRecipeResponseDto(String subName) {
        String url = urlBuilder.buildUrlForRecipeSearchBySubstring(subName);
        return restTemplate.getForObject(url, SpoonacularListOfRecipeDto.class);
    }
}