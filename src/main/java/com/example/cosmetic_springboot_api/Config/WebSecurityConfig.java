package com.example.cosmetic_springboot_api.Config;

import com.example.cosmetic_springboot_api.Filter.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/api/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/api/users/**").permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/api/category/**").permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/api/brand/**").permitAll()
                        .requestMatchers(HttpMethod.POST,
                                "/api/product/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/product/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/product/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,
                                "/api/category/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/category/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/category/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,
                                "/api/brand/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/brand/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/brand/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }
}
