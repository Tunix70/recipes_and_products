package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import com.syncretis.recipes_and_products.service.activity.ActivityService;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActivityController.class)
@AutoConfigureMockMvc(addFilters = false)
class ActivityControllerTest {
    public static final String SEARCHSTRING = "run";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ActivityService service;

    @Test
    void shouldReturnActivity() throws Exception {
        //GIVEN
        ActivityDto expected = new ActivityDto("running", 11.43);
        given(service.getActivity(anyString())).willReturn(expected);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/activities?activity=" + SEARCHSTRING));
        //THEN
        actual.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.name", CoreMatchers.is("running")))
                .andExpect(jsonPath("$.burntCalories", CoreMatchers.is(11.43)));
    }

    @Test
    void shouldReturnHttpStatusNotFound() throws Exception {
        //GIVEN
        given(service.getActivity(anyString())).willReturn(null);
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/activities?activity="));
        //THEN
        actual.andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldReturnMissingServletRequestParameterException() throws Exception {
        //WHEN
        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/activities?"));
        //THEN
        actual.andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException));
    }
}