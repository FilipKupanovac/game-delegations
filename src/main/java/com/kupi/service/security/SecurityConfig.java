package com.kupi.service.security;

import com.kupi.service.security.filter.KeycloakAuthenticationFilter;
import com.kupi.service.security.filter.UsernamePasswordFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configurer ->
                                configurer
                                        .requestMatchers(antMatcher(HttpMethod.DELETE)).hasRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.POST)).hasRole("ADMIN")
                                        .requestMatchers(antMatcher("/v1/public**")).permitAll()
                                        .requestMatchers(antMatcher("/v1/frontend**")).authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(new KeycloakAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new UsernamePasswordFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
