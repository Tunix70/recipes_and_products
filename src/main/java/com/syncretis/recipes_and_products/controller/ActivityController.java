package com.syncretis.recipes_and_products.controller;

import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import com.syncretis.recipes_and_products.service.activity.ActivityService;
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

@RestController
@SecurityRequirement(name = "security_auth")
@RequestMapping("/api/activities")
@Tag(name = "Activity Controller", description = "Activity search operation")
public class ActivityController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @Operation(summary = "Search activity by activity.", description = "This method return an activity with:\n" +
            "Name\n" +
            "Calories expended per minute")
    @GetMapping()
    public ResponseEntity<ActivityDto> getActivityByString(
            @Parameter(description = "The field filled with activity name", example = "run") @RequestParam("activity") String activity) {
        ActivityDto response = service.getActivity(activity);
        return response == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }
}