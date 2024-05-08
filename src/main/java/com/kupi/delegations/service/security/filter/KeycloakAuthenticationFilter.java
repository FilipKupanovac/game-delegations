package com.kupi.delegations.service.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class KeycloakAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication existingAuthentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(existingAuthentication) || !existingAuthentication.isAuthenticated()) {
            //metoda unutar klase za resolve autentikacije...
        }

        filterChain.doFilter(request, response);
    }
}
