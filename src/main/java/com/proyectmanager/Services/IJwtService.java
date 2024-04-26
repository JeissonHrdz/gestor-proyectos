package com.proyectmanager.Services;

import java.security.Key;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
 
@Service
public interface IJwtService {

    public String getToken(UserDetails user);
    public String getToken(Map<String, Object> extraClaims, UserDetails user);
    public Key getKey();
    
}
