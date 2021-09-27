package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.service.ingredient.IngredientService;
import com.syncretis.recipes_and_products.util.RapIngredientDtos;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IngredientController.class)
@AutoConfigureMockMvc(addFilters = false)
public class IngredientControllerTest {
    public static final String SUB_NAME = "ban";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IngredientService ingredientService;

    private final double calories = 1.1;
    private final double protein = 1.2;
    private final double fat = 1.3;
    private final double carbohydrates = 1.4;
    private final double glycemicIndex = 1.5;
    private final double coefficient = 1;

    @Test
    void shouldReturnListIngredients() throws Exception {
        //GIVEN
        List<IngredientDto> expected = RapIngredientDtos.getSomeIngredientList(glycemicIndex, calories, protein,
                fat, carbohydrates, coefficient);
        given(ingredientService.getIngredients(SUB_NAME)).willReturn(expected);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients?name=" + SUB_NAME));
        //THEN
        actual.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].Name", CoreMatchers.is("name1")))
                .andExpect(jsonPath("$[0].['Glycemic Index']", CoreMatchers.is(glycemicIndex)))
                .andExpect(jsonPath("$[0].Nutrition.Calories").value(calories))
                .andExpect(jsonPath("$[0].Nutrition.Protein").value(protein))
                .andExpect(jsonPath("$[0].Nutrition.Fat").value(fat))
                .andExpect(jsonPath("$[0].Nutrition.Carbohydrates").value(carbohydrates))
                .andExpect(jsonPath("$[1].Name", CoreMatchers.is("name2")))
                .andExpect(jsonPath("$[1].['Glycemic Index']", CoreMatchers.is(glycemicIndex + coefficient)))
                .andExpect(jsonPath("$[1].Nutrition.Calories").value(calories + coefficient))
                .andExpect(jsonPath("$[1].Nutrition.Protein").value(protein + coefficient))
                .andExpect(jsonPath("$[1].Nutrition.Fat").value(fat + coefficient))
                .andExpect(jsonPath("$[1].Nutrition.Carbohydrates").value(carbohydrates + coefficient));
    }

    @Test
    void shouldReturnHttpStatusNotFound() throws Exception {
        //GIVEN
        given(ingredientService.getIngredients(any())).willReturn(null);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients?name="));
        //THEN
        actual.andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldReturnMissingServletRequestParameterException() throws Exception {
        //GIVEN
        given(ingredientService.getIngredients(any())).willReturn(null);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients?"));
        //THEN
        actual.andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException));
    }
}
