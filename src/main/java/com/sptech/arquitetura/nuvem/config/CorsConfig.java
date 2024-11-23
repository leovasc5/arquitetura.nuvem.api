package com.sptech.arquitetura.nuvem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permite todos os domínios
        config.addAllowedMethod("*"); // Permitir todos os métodos (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permitir todos os headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplica a todas as rotas
        return new CorsFilter(source);
    }

}
