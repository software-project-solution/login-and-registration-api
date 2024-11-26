package com.hiranwj.login_and_registration_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Explicitly disabling CSRF
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/v1/employee/save").permitAll() // Allow public access to specific endpoint
                    .requestMatchers("/api/v1/employee/login").permitAll()
                    .anyRequest().authenticated() // Require authentication for all other endpoints
            );
        return http.build();
    }
}
