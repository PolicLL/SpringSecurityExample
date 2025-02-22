package com.example.SpringSecurityExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
//    return httpSecurity.csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//        .formLogin(Customizer.withDefaults()) // include form login for browser
//        .httpBasic(Customizer.withDefaults()) // include it so that Auth works for Postman
//        .build();


    Customizer<CsrfConfigurer<HttpSecurity>> customCsrf = customizer -> {

    };

    httpSecurity.csrf(customCsrf);

    return httpSecurity.build();

  }

}
