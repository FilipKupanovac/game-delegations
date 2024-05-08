package com.kupi.delegations.service.security.filter;

import com.kupi.delegations.service.security.resolver.AuthenticationResolver;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class UsernamePasswordFilter extends OncePerRequestFilter {

    private final AuthenticationResolver authenticationResolver;

    public UsernamePasswordFilter(AuthenticationResolver authenticationResolver) {
        this.authenticationResolver = authenticationResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication existingAuthentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(existingAuthentication) || !existingAuthentication.isAuthenticated()) {
            if (authenticationResolver.supports(request)) {
                Authentication authenticate = authenticationResolver.authenticate(request);
                if (Objects.nonNull(authenticate)) {
                    SecurityContextHolder.getContext().setAuthentication(authenticate);
                }
                else {
                    SecurityContextHolder.clearContext();
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
