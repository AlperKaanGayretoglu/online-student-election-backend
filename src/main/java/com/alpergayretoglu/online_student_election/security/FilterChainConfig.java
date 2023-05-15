package com.alpergayretoglu.online_student_election.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class FilterChainConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final SelfFilter selfFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui/index.html").permitAll()  // OpenAPI
                .requestMatchers("/v3/api-docs").permitAll()            // OpenAPI

                .requestMatchers("/auth/login").permitAll()

                .requestMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ADMIN", "SELF")
                .requestMatchers("/user").hasAuthority("ADMIN")
                .requestMatchers("/user/**").hasAuthority("ADMIN")

                .anyRequest().authenticated() // security ON
                // .anyRequest().permitAll() // security OFF
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(selfFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter, SelfFilter.class);

        return http.build();
    }

}