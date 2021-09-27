package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.IngredientDto;
import com.syncretis.recipes_and_products.service.ingredient.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "security_auth")
@RequestMapping("/api/ingredients")
@Tag(name = "Ingredient Controller", description = "Operations about ingredients")
public class IngredientController {
    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @Operation(summary = "Search ingredients by subname.", description = "Searching ingredients by subname and get their nutrients")
    @GetMapping()
    public ResponseEntity<List<IngredientDto>> getListIngredientBySubstring(
            @Parameter(description = "The name that needs to be fetched ingredients.", example = "apple") @RequestParam("name") String name) {
        List<IngredientDto> response = service.getIngredients(name);
        return response == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }
}