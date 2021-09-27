package com.syncretis.recipes_and_products.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PingController.class)
@AutoConfigureMockMvc(addFilters = false)
class PingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHttpStatusOk() throws Exception {
        // GIVEN
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/api/ping"));
        // THEN
        perform
                .andExpect(content().string(containsString("Application is running.")))
                .andExpect(status().isOk());
    }
}