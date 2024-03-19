package br.com.redesenhe.leap.config.security;

import br.com.redesenhe.leap.adapter.security.AuthenticationFilterBeforeAfter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class IWebSecurityConfigurerAdapter  {

    private final AuthenticationFilterBeforeAfter authenticationFilterBeforeAfter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         http.csrf(AbstractHttpConfigurer::disable)
                 .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(this.authenticationFilterBeforeAfter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
