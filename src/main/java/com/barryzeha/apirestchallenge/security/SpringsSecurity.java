package com.barryzeha.apirestchallenge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringsSecurity {
    // In Spring Boot, when you annotate a method with @Bean inside a @Configuration class,
    // you are telling the Spring container:
    //
    // "Please manage the object returned by this method (IoC)
    // so it can be reused and injected wherever it is needed."

    // Bean for encrypt passwords with BCrypt
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Bean that defines the security rules
    // For testing purposes, we allow all routes to be public.
    // By default, Spring Security enforces authentication rules
    // and will require a username and password for every request
    // unless we explicitly configure it otherwise.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable()) // desactiva CSRF en APIs REST
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // todas las rutas accesibles
                );
        return http.build();
    }
}
