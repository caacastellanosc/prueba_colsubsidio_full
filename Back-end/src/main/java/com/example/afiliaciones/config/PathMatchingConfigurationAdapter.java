package com.example.afiliaciones.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase con al configuración de rutas a interceptar
 */
@Configuration
public class PathMatchingConfigurationAdapter implements WebMvcConfigurer {

    /**
     * representa la variable de clase de tipo instancia de un RequestInterceptor
     */
    private RequestInterceptor requestInterceptor;

    /**
     * Constructor con argumentos de la clase
     * @param requestInterceptor representa el atributo requestInterceptor 
     */
    public PathMatchingConfigurationAdapter(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    /**
     * @see WebMvcConfigurer#addInterceptors(InterceptorRegistry)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor);
    }
}
