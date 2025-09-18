package com.floricultura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity // habilita @PreAuthorize
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .antMatchers("/usuarios/**").permitAll() // cadastro/login liberado
                        .anyRequest().authenticated()
                )
                .httpBasic(); // Exemplo simples, pode trocar para JWT
        return http.build();
    }
}