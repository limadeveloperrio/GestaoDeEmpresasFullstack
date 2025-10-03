package com.companybruno.demoAPI.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API da Empresa")
                        .version("v1.0")
                        .description("Esta API pertence a uma organização privada com mais de 50 colaboradores. "
                                + "Nosso objetivo é fornecer serviços de gestão de empresas de forma eficiente e segura. "
                                + "Bem-vindo ao nosso portal de integração!")
                        .contact(new Contact()
                                .name("Bruno Lima")
                                .email("bruno@empresa.com")
                                .url("https://www.empresa.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
    }
}

