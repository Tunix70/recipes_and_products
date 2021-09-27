package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.RecipeDto;
import com.syncretis.recipes_and_products.service.recipe.RecipeService;
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
@RequestMapping("/api/recipes")
@SecurityRequirement(name = "security_auth")
@Tag(name = "Recipe Controller", description = "Operations about recipes")
public class RecipeController {
    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @Operation(summary = "Search recipes by subname.",
            description = "Searching recipes by subname and get their information and recipes")
    @GetMapping()
    public ResponseEntity<List<RecipeDto>> getListRecipesBySubstring
            (@Parameter(description = "The name that needs to be fetched recipes.", example = "soup") @RequestParam("name") String name) {
        List<RecipeDto> response = service.getRecipes(name);
        return response == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }
}
