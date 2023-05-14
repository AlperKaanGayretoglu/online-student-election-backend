package com.alpergayretoglu.online_student_election.security;

import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public Authentication claimsToAuthentication(Jws<Claims> jws) {
        if (jws == null)
            return null;
        String email = jws.getBody().getSubject(); // email
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException(email); // even though jwt is valid, email does not exist
        });
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        Jws<Claims> jws = jwtService.verifyAuthHeader(authorizationHeader);
        Authentication authentication = claimsToAuthentication(jws);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}