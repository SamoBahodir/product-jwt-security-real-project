package com.productexseption.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info =@Info(
                title = "Swagger service",
                version = "1.0",
                contact = @Contact(
                        name = "Swagger service SUPPORT", email = "turayev.bahodir95@gmail.com"
                ),
                description = "Swagger service resources"
        ),
        servers = {
                @Server(url = "http://localhost:${server.port}", description = "Local development"),
                @Server(url = "http://localhost:${server.port}", description = "Local development"),
        }
)
@SecurityScheme(
        name = SwaggerConfig.BEARER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
public class SwaggerConfig {


    public static final String BEARER = "Authorization";

}
