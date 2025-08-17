package com.barryzeha.apirestchallenge.security;

import com.barryzeha.apirestchallenge.services.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    // If a class like JwtService is annotated with @Service, @Component, or defined as a @Bean in a @Configuration,
    // Spring will automatically register it in the ApplicationContext and make it available for dependency injection
    // wherever it is needed.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtService jwtService) throws Exception{

        http
                // CSRF protection is designed for traditional web applications using cookies and server-side sessions.
                // Since this project uses JWT for authentication in a stateless REST API, CSRF protection is not required.
                // Therefore, we explicitly disable it to avoid unnecessary token validation in requests.
                .csrf(csrf -> csrf.disable()) // deactivate CSRF in APIs REST
                .authorizeHttpRequests(auth -> auth
                        // Require authentication for the "/users" endpoint.
                        // If you don’t want to protect this route, remove it from here.
                        // You can also add other endpoints to this matcher if they should be protected.
                        .requestMatchers("/users").authenticated()
                        .anyRequest().permitAll() // All other routes are public
                ).addFilterBefore(new JwtAuthFilter(jwtService),
                        UsernamePasswordAuthenticationFilter.class);
        ;
        return http.build();
    }
}
