package com.example.animals;  // Use your package name

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/mammals/**")  // Apply CORS to the /api/v1/mammals path
                .allowedOrigins("http://localhost:4200")  // Allow requests from this origin (Angular app)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (optional, needed if you're using cookies/sessions)

        registry.addMapping("/api/v1/entries/**")  // Apply CORS to the /api/v1/mammals path
                .allowedOrigins("http://localhost:4200")  // Allow requests from this origin (Angular app)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);
    }
}
