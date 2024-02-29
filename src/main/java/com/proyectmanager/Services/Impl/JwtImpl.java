package com.proyectmanager.Services.Impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.proyectmanager.Services.IJwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtImpl implements  IJwtService {

    private static final String SECRET_KEY = "55CD9B6152AA3365CACB1BFB219FE";

    @Override
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    @Override
    public String getToken(Map<String, Object> extraClaims, UserDetails user) {
       return Jwts
       .builder()
       .setClaims(extraClaims)
       .setSubject(user.getUsername())
       .setIssuedAt(new Date(System.currentTimeMillis()))
       .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
       .signWith(getKey(), SignatureAlgorithm.HS256)
       .compact();

    }

    @Override
    public Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
}
