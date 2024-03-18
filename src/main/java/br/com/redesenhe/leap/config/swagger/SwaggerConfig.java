package br.com.redesenhe.leap.config.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ConditionalOnProperty(value = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${app.title:unknown}")
    private String name;

    @Value("${app.description:unknown}")
    private String description;

    @Value("${app.version:unknown}")
    private String version;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/swagger-ui/")
                .setViewName("forward:" + "/swagger-ui/index.html");
    }

    @Bean
    public OpenAPI springShopOpenApi(){
        return new OpenAPI()
                .info(new Info().title(this.name)
                        .description(this.description)
                        .version(this.version));
    }
}
