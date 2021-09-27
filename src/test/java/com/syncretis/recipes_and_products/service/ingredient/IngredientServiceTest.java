package com.syncretis.recipes_and_products.service.ingredient;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.dto.rap.NutritionDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientNameResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientResponseDto;
import com.syncretis.recipes_and_products.mapper.IngredientDtoResponseMapper;
import com.syncretis.recipes_and_products.service.spoonacular.BodyParametersBuilder;
import com.syncretis.recipes_and_products.service.spoonacular.SpoonacularService;
import com.syncretis.recipes_and_products.util.SpoonacularIngredientDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class IngredientServiceTest {
    private static final String NAME = "name";
    @Mock
    private IngredientDtoResponseMapper mapper;
    @Mock
    private SpoonacularService spoonacularService;
    @Mock
    private BodyParametersBuilder bodyParametersBuilder;
    @InjectMocks
    private IngredientService service;

    @Test
    void shouldReturnIngredientsList() {
        //GIVEN
        IngredientNameResponseDto[] ingredientNameResponseDtos =
                SpoonacularIngredientDtos.getSomeIngredientNameResponseDtos();
        IngredientResponseDto[] ingredientsResponseDto =
                SpoonacularIngredientDtos.getSomeIngredientResponseDto();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("ingredientList", "name1" + "\n" + "name2" + "\n");

        NutritionDto nutritionDto1 = getSomeNutritionDto(2);
        NutritionDto nutritionDto2 = getSomeNutritionDto(3);
        List<IngredientDto> expected = List.of(
                new IngredientDto("ingredient1", 2.1, nutritionDto1),
                new IngredientDto("ingredient2", 2.3, nutritionDto2)
        );
        given(bodyParametersBuilder.buildBodyForIngredientSearch(any())).willReturn(map);
        given(spoonacularService.getIngredientsNamesBySubName(NAME)).willReturn(ingredientNameResponseDtos);
        given(spoonacularService.getAllInformationOfIngredients(map)).willReturn(ingredientsResponseDto);
        given(mapper.mapIngredientDtoResponseList(any())).willReturn(expected);
        //WHEN
        List<IngredientDto> actual = service.getIngredients(NAME);
        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    private NutritionDto getSomeNutritionDto(int coefficient) {
        return new NutritionDto(
                100 * coefficient, 110 * coefficient, 120 * coefficient, 130 * coefficient);
    }
}