package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.service.user.UserGoalService;
import com.syncretis.recipes_and_products.validator.DesiredWeightConstraint;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@SecurityRequirement(name = "security_auth")
@RequestMapping("/api/users")
@Tag(name = "User information Controller", description = "Operations about information of user")
public class UserController {
    private final UserGoalService service;

    public UserController(UserGoalService service) {
        this.service = service;
    }

    @Operation(summary = "Set the desired weight.", description = "Setting the desired weight. And getting KCal/day.")
    @PostMapping(value = "/goals")
    public ResponseEntity<UserGoalDto> setWeightGoal(@Parameter(description = "The desired weight.", example = "80")
                                                     @RequestParam("weight") @DesiredWeightConstraint double weight) {
        UserGoalDto response = service.setGoal(weight);
        return response == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Get the desired weight and KCal/day.", description = "Getting the desired weight and KCal/day.")
    @GetMapping(value = "/goals")
    public ResponseEntity<UserGoalDto> getGoal() {
        UserGoalDto response = service.getGoal();
        return response == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete the goal.", description = "Goal deletion.")
    @DeleteMapping(value = "/goals")
    public void deleteGoal() {
        service.deleteGoal();
    }
}