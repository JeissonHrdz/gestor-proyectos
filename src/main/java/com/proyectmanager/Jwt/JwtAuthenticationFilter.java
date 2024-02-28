package com.proyectmanager.Jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter  extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
        final String token =  getTokerFromRequest(request);

        if(token == null){
            filterChain.doFilter(request, response);
            return;
        }

        filterChain.doFilter(request, response);

               
    }
    // Metodo para obtener el token de las peticion
    private String getTokerFromRequest(HttpServletRequest request){
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Se verifica que el token emiez con la palabra bearer y tenga texto
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            // si es asi, se toma el token desde el caracter 7
            return authHeader.substring(7);
        }
        return null;
    }
    
}
