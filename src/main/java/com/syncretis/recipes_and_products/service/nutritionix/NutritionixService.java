package com.syncretis.recipes_and_products.service.nutritionix;

import com.syncretis.recipes_and_products.dto.nutritionix.NutritionixActivitiesDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class NutritionixService {
    @Value("${nutritionix.api-key}")
    private String apiKey;
    @Value("${nutritionix.app-id}")
    private String appId;
    private final RestTemplate restTemplate;
    private final NutritionixUrlBuilder urlBuilder;

    public NutritionixService(
            RestTemplate restTemplate, NutritionixUrlBuilder urlBuilder) {
        this.restTemplate = restTemplate;
        this.urlBuilder = urlBuilder;
    }

    public NutritionixActivitiesDto getExercise(String query) {
        query = query.trim() + " 1 min";
        HttpEntity<Map<String, String>> request = buildRequest(query);
        return restTemplate.postForObject(urlBuilder.buildPostRequestUrl(), request, NutritionixActivitiesDto.class);
    }

    private HttpEntity<Map<String, String>> buildRequest(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> headersMap = Map.of("x-app-id", appId, "x-app-key", apiKey);
        Map<String, String> body = Map.of("query", query);
        headers.setAll(headersMap);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(body, headers);
    }
}