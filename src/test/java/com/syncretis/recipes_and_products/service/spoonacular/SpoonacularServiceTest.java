package com.syncretis.recipes_and_products.service.spoonacular;

import com.syncretis.recipes_and_products.dto.spoonacular.IngredientNameResponseDto;
import com.syncretis.recipes_and_products.dto.spoonacular.IngredientResponseDto;
import com.syncretis.recipes_and_products.util.SpoonacularIngredientDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SpoonacularServiceTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private UrlBuilder urlBuilder;

    @InjectMocks
    private SpoonacularService service;

    @Test
    void shouldReturnArrayOfIngredientNameResponseDto() {
        //GIVEN
        String name = "name";
        IngredientNameResponseDto[] expected = SpoonacularIngredientDtos.getSomeIngredientNameResponseDtos();
        String url = "sdfgdfg";

        given(urlBuilder.buildUrlForAutocompleteIngredientSearch(name))
                .willReturn(url);

        given(restTemplate.getForObject(url, (IngredientNameResponseDto[].class)))
                .willReturn(expected);
        //WHEN
        IngredientNameResponseDto[] actual = service.getIngredientsNamesBySubName(name);
        //THEN
        verify(urlBuilder).buildUrlForAutocompleteIngredientSearch(name);
        verify(restTemplate).getForObject(url, (IngredientNameResponseDto[].class));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnArrayIngredientResponseDto() {
        //GIVEN
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("ingredientList", "name1" + "\n" + "name2" + "\n");
        String url = "dfgdfg";

        IngredientResponseDto[] expected = SpoonacularIngredientDtos.getSomeIngredientResponseDto();

        given(urlBuilder.buildUrlForParseIngredientsSearch()).willReturn(url);
        given(restTemplate.postForObject(eq(url), any(), eq(IngredientResponseDto[].class))).willReturn(expected);
        //WHEN
        IngredientResponseDto[] actual = service.getAllInformationOfIngredients(map);
        //THEN
        verify(urlBuilder).buildUrlForParseIngredientsSearch();
        verify(restTemplate).postForObject(eq(url), any(), eq(IngredientResponseDto[].class));
        assertThat(actual).isEqualTo(expected);
    }
}