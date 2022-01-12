package de.workshops.bookdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@Profile("prod")
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .info(
                new Info()
                    .title("Bookshelf API")
                    .version("v0.0.1")
                    .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")));
    }
}
