package com.example.Proyecto_final_biblioteca.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api Gestion de libros")
                        .version("1.0")
                        .description("Documentacion de la API para gestionar la BD de los prestamos de unos libros")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("ygtorres@ucundinamarca.edu.co")));
    }
}

