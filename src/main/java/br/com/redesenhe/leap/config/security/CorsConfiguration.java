package br.com.redesenhe.leap.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

        /*
        //liberando app cliente 1
        registry.addMapping("/**")
             .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

        //liberando app cliente 2
        registry.addMapping("/topicos/**")
             .allowedOrigins("http://localhost:4000")
            .allowedMethods("GET", "OPTIONS", "HEAD", "TRACE", "CONNECT");
         */
    }

}
