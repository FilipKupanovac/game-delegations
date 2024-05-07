package com.kupi.service.security.resolver;

import com.kupi.persistence.entity.UserEntity;
import com.kupi.persistence.repository.UserRepository;
import com.kupi.service.security.UserDetailsImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationResolver {

    private static final String FRONTEND_API_PREFIX = "v1/frontend/";
    private final UserRepository userRepository;

    public AuthenticationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean supports(HttpServletRequest request) {
        return //request.getHeader(HttpHeaders.AUTHORIZATION).startsWith(BEARER_PREFIX) && todo - used for bearer tokens
                request.getRequestURI().contains(FRONTEND_API_PREFIX);
    }

    public Authentication authenticate(HttpServletRequest request) {
        UserEntity user = null;
        String email = request.getHeader("Email");
        String password = request.getHeader("Password");
        if (userRepository.existsByEmailAndEncryptedPassword(email, password)) {
            user = getUserByEmailAndPassword(email, password);
        } else {
            // todo - space for implementing another ways of authentication - by username or smth like that
            return null;
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(user.getEmail(), user.getEncryptedPassword(), user.getUuid(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        return new UsernamePasswordAuthenticationToken(userDetails, email, userDetails.getAuthorities());
    }

    private UserEntity getUserByEmailAndPassword(String email, String encryptedPassword) {
        return userRepository.findByEmailAndEncryptedPassword(email, encryptedPassword)
                .orElseThrow(EntityNotFoundException::new);
    }
}
