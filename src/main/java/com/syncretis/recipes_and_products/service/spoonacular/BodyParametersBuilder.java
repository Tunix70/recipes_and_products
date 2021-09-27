package com.syncretis.recipes_and_products.service.spoonacular;

import com.syncretis.recipes_and_products.dto.spoonacular.IngredientNameResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class BodyParametersBuilder {
    public MultiValueMap<String, String> buildBodyForIngredientSearch(IngredientNameResponseDto[] ingredientNameResponseDtos) {
        String names = buildStringOfNames(ingredientNameResponseDtos);
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("ingredientList", names);
        return parameters;
    }

    private String buildStringOfNames(IngredientNameResponseDto[] ingredientNameResponseDtos) {
        StringBuilder result = new StringBuilder();
        for (IngredientNameResponseDto name : ingredientNameResponseDtos) {
            result.append(name.getName()).append('\n');
        }
        return result.toString();
    }
}