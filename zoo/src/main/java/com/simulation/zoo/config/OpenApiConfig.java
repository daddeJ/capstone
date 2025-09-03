package com.simulation.zoo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
TODO: annotate configuration class with '@Configuration'
    - Marks the class as a Spring configuration class.
    - Enables Spring to detect @Bean definitions and manage them in the application context.
    Example:
        @Configuration
        public class OpenApiConfig { ... }

TODO: define OpenAPI bean
    - Configures OpenAPI (Swagger) for automatic API documentation.
    - Provides metadata such as title, version, and description for the API.
    Example:
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Zoo API")
                            .version("1.0.0")
                            .description("API for Zoo Management System"));
        }

TODO: general OpenAPI configuration structure
    - Class-level annotation: @Configuration
    - Defines @Bean method returning OpenAPI instance.
    - Centralizes API documentation metadata for all REST controllers.
*/

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Zoo API")
                        .version("1.0.0")
                        .description("API for Zoo Management System"));
    }
}