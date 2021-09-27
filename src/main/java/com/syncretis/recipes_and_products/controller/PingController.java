package com.syncretis.recipes_and_products.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
@SecurityRequirement(name = "security_auth")
@Tag(name = "Ping Controller", description = "Ping to application to check that is running")
public class PingController {
    @GetMapping
    @Operation(summary = "Ping", description = "Ping to application to check that is running")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Application is running.", HttpStatus.OK);
    }
}