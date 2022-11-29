package com.example.afiliaciones.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Clase con la lógica de configuración para Intercambio de recursos de origen cruzado
 */
@Configuration
public class CorsConfig {

    @Value("#{'${cors.origins}'.split(',')}")
    private List<String> origins;

    @Value("#{'${cors.headers}'.split(',')}")
    private List<String> headers;

    /**
     * metodo encargado de establecer la configuracion de los origenes Headers permitidos y metodos http permitidos
     * @return retorna el objeto WebMvcConfigurer con la configuracion establecida
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(origins.stream().toArray(String[]::new))
                        .allowedMethods(headers.stream().toArray(String[]::new))
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }
}
