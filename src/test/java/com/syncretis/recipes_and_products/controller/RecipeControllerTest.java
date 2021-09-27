package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.service.recipe.RecipeService;
import com.syncretis.recipes_and_products.util.SpoonacularRecipeDtos;
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

@WebMvcTest(controllers = RecipeController.class)
@AutoConfigureMockMvc(addFilters = false)
class RecipeControllerTest {
    public static final String SUB_NAME = "sou";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RecipeService recipeService;

    @Test
    void shouldReturnListRecipes() throws Exception {
        //GIVEN
        List<RecipeDto> expected = SpoonacularRecipeDtos.getSomeListRecipeDto();

        given(recipeService.getRecipes(SUB_NAME)).willReturn(expected);
        //WHEN
        ResultActions aclual = mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes?name=" + SUB_NAME));
        //THEN
        aclual.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name", CoreMatchers.is("Soup")))
                .andExpect(jsonPath("$[0].glutenFree").value(false))
                .andExpect(jsonPath("$[0].dairyFree").value(true))
                .andExpect(jsonPath("$[1].name", CoreMatchers.is("Super Soup")))
                .andExpect(jsonPath("$[1].glutenFree").value(true))
                .andExpect(jsonPath("$[1].dairyFree").value(false));
    }

    @Test
    void shouldReturnHttpStatusNotFound() throws Exception {
        //GIVEN
        given(recipeService.getRecipes(any())).willReturn(null);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes?name="));
        //THEN
        actual.andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldReturnMissingServletRequestParameterException() throws Exception {
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes?"));
        //THEN
        actual.andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException));
    }
}