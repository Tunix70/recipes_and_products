package com.syncretis.recipes_and_products.service.ingredient;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientNameResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientResponseDto;
import com.syncretis.recipes_and_products.mapper.IngredientDtoResponseMapper;
import com.syncretis.recipes_and_products.service.spoonacular.BodyParametersBuilder;
import com.syncretis.recipes_and_products.service.spoonacular.SpoonacularService;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class IngredientService {
    private final SpoonacularService spoonacularService;
    private final BodyParametersBuilder bodyParametersBuilder;
    private final IngredientDtoResponseMapper mapper;

    public IngredientService(SpoonacularService spoonacularService, BodyParametersBuilder bodyParametersBuilder,
                             IngredientDtoResponseMapper mapper) {
        this.spoonacularService = spoonacularService;
        this.bodyParametersBuilder = bodyParametersBuilder;
        this.mapper = mapper;
    }

    public List<IngredientDto> getIngredients(String subName) {
        IngredientNameResponseDto[] ingredientsNames = spoonacularService.getIngredientsNamesBySubName(subName);
        MultiValueMap<String, String> parametersForIngredientSearch =
                bodyParametersBuilder.buildBodyForIngredientSearch(ingredientsNames);
        IngredientResponseDto[] allInformationOfIngredients =
                spoonacularService.getAllInformationOfIngredients(parametersForIngredientSearch);
        return mapFromIngredientResponseDtoToIngredientDto(allInformationOfIngredients);
    }

    private List<IngredientDto> mapFromIngredientResponseDtoToIngredientDto(IngredientResponseDto[] ingredientResponseDtos) {
        return mapper.mapIngredientDtoResponseList(ingredientResponseDtos);
    }
}