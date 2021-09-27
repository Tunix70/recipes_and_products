package com.syncretis.recipes_and_products.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                implicit =
                @OAuthFlow(
                        authorizationUrl = "https://login.microsoftonline.com/27d1d5a7-306f-4239-ab67-3bd61777078a/oauth2/v2.0/authorize",
                        scopes = {
                                @OAuthScope(
                                        name = "api://4ff87c50-e5f9-48ed-b6e2-d7bb5dbd1d57/default")
                        }
                )
        )
)
public class OpenApiConfig {
}