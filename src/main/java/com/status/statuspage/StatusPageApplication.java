package com.status.statuspage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StatusPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatusPageApplication.class, args);
	}

}

@Configuration
class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	            .allowedOrigins("http://localhost:3000")  // No trailing slash
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Explicitly allow methods
	            .allowedHeaders("*")  // Allow all headers
	            .exposedHeaders("Authorization", "Content-Type")  // Specify any exposed headers, if necessary
	            .allowCredentials(true);  // Allow cookies/auth headers
	}
}