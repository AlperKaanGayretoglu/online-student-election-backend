package com.alpergayretoglu.online_student_election.security;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SelfFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String userId = authentication.getName();
            if (request.getRequestURI().contains(userId)) {
                List<GrantedAuthority> updatedAuthorities = new LinkedList<>(authentication.getAuthorities());
                updatedAuthorities.add(new SimpleGrantedAuthority(SecurityConstants.SELF));
                Authentication newAuthentication = new UsernamePasswordAuthenticationToken(
                        authentication.getPrincipal(),
                        authentication.getCredentials(),
                        updatedAuthorities
                );
                SecurityContextHolder.getContext().setAuthentication(newAuthentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
