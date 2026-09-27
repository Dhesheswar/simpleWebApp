package com.spring.simpleWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception{

        httpSec.csrf(customizer -> customizer.disable());
        httpSec.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        //httpSec.formLogin(Customizer.withDefaults());
        httpSec.httpBasic(Customizer.withDefaults());
        httpSec.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSec.build();
    }
}
