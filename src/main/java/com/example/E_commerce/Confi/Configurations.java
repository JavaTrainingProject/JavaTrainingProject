package com.example.E_commerce.Confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Configurations {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable csrf for Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").permitAll() // allow all user APIs
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
