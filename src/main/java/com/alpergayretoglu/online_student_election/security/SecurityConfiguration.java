package com.alpergayretoglu.online_student_election.security;

import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final SelfFilter selfFilter;

    @Autowired
    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter, SelfFilter selfFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.selfFilter = selfFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()

                // PUBLIC
                .antMatchers("/", "/v2/api-docs/**", "/swagger.json", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/csrf").permitAll()
                .antMatchers("/auth/**").permitAll()

                // ADMIN OR SELF
                .antMatchers(HttpMethod.GET,
                        "/user", "/user/**"
                ).hasAnyAuthority(UserRole.ADMIN.name(), SecurityConstants.SELF)

                .antMatchers(HttpMethod.POST,
                        "/user", "/user/**",
                        "/election/cast-vote/**"
                ).hasAnyAuthority(UserRole.ADMIN.name(), SecurityConstants.SELF)

                .antMatchers(HttpMethod.PUT,
                        "/user", "/user/**"
                ).hasAnyAuthority(UserRole.ADMIN.name(), SecurityConstants.SELF)

                // ADMIN ONLY
                .antMatchers(HttpMethod.POST,
                        "/election", "/election/**",
                        "/department", "/department/**",
                        "/announcement", "/announcement/**"
                ).hasAuthority(UserRole.ADMIN.name())

                .antMatchers(HttpMethod.PUT,
                        "/election", "/election/**",
                        "/department", "/department/**",
                        "/announcement", "/announcement/**"
                ).hasAuthority(UserRole.ADMIN.name())

                .antMatchers(HttpMethod.DELETE,
                        "/election", "/election/**",
                        "/department", "/department/**",
                        "/announcement", "/announcement/**"
                ).hasAuthority(UserRole.ADMIN.name())

                // OTHER
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(selfFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, SelfFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() { // TODO: Find out if this is necessary or not
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
