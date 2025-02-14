package com.example.showcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Applica CORS a tutte le API sotto /api/
                        .allowedOrigins("http://localhost:4200")  // Permetti solo richieste dal frontend Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Metodi permessi
                        .allowedHeaders("*")  // Permetti tutti gli headers
                        .allowCredentials(true);  // Permetti l'invio di cookie (opzionale)
            }
        };
    }
}
