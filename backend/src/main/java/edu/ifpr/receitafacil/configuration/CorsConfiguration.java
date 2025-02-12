package edu.ifpr.receitafacil.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost:5173")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*"); // Permite todos os cabeçalhos
    }

}