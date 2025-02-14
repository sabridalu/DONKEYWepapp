package com.example.showcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disabilita la protezione CSRF per le API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/newsletter/**").permitAll()  // Permetti l'accesso alla newsletter
                .anyRequest().permitAll()  // Permetti l'accesso a tutti gli altri endpoint
            );

        return http.build();
    }
}
