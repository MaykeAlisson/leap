package br.com.redesenhe.leap.config;

import br.com.redesenhe.leap.adapter.out.InsertUserAdapter;
import br.com.redesenhe.leap.application.core.usecase.InsertUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertUserConfig {

    @Bean
    public InsertUserUseCase insertUserUseCase(InsertUserAdapter insertUserAdapter){
        return new InsertUserUseCase(insertUserAdapter);
    }
}
