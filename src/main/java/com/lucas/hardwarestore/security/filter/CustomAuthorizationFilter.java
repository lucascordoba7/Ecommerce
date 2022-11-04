package com.lucas.hardwarestore.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/login")) {
            filterChain.doFilter(request, response);
        } else {
            final String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (StringUtils.isNotEmpty(authorizationHeader)) {
               try {
                   final String token = authorizationHeader.substring("Bearer ".length());
                   final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                   final JWTVerifier verifier = JWT.require(algorithm).build();
                   final DecodedJWT decodedJWT = verifier.verify(token);
                   final String username = decodedJWT.getSubject();
                   final String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                   final Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                   Arrays.stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

                   UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);

                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
               }catch (Exception e){
                   log.error("Authorization error: {}", e.getMessage());
                   response.setHeader("error", e.getMessage());
                   response.setStatus(HttpServletResponse.SC_FORBIDDEN,e.getMessage());
                   //response.sendError(HttpServletResponse.SC_FORBIDDEN,e.getMessage());
                   final Map<String, String> error = new HashMap<>();
                   error.put("error", e.getMessage());
                   response.setContentType(APPLICATION_JSON_VALUE);
                   new ObjectMapper().writeValue(response.getOutputStream(), error);
               }
            }
            filterChain.doFilter(request, response);
        }
    }
}
