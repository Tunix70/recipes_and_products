package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.exception.UserGoalNotFountException;
import com.syncretis.recipes_and_products.service.user.UserGoalService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserGoalService service;


    @Test
    void shouldReturnKCalPerDayInPostRequest() throws Exception {
        //GIVEN
        UserGoalDto expected = new UserGoalDto(80d, 1800);
        given(service.setGoal(80d)).willReturn(expected);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/users/goals?weight=80"));
        //THEN
        actual
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.goalWeight", CoreMatchers.is(80d)))
                .andExpect(jsonPath("$.kcalPerDay", CoreMatchers.is(1800d)))
        ;
        verify(service).setGoal(80d);
    }

    @Test
    void shouldReturnBadRequestError() throws Exception {
        //GIVEN
        UserGoalDto expected = new UserGoalDto(-80d, 1800);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/users/goals?weight=-80"));
        //THEN
        actual
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0]", CoreMatchers.is("Weight should be between 4 and 300.")))
        ;
    }

    @Test
    void shouldReturnKCalPerDayInGetRequest() throws Exception {
        //GIVEN
        UserGoalDto expected = new UserGoalDto(80d, 1800);
        given(service.getGoal()).willReturn(expected);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/goals?weight=80"));
        //THEN
        actual
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.goalWeight", CoreMatchers.is(80d)))
                .andExpect(jsonPath("$.kcalPerDay", CoreMatchers.is(1800d)))
        ;
        verify(service).getGoal();
    }

    @Test
    void shouldReturnNotFoundError() throws Exception {
        //GIVEN
        given(service.getGoal()).willThrow(new UserGoalNotFountException(HttpStatus.NOT_FOUND));
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/goals?weight=80"));
        //THEN
        actual
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.length()").doesNotExist())
        ;
        verify(service).getGoal();
    }
}