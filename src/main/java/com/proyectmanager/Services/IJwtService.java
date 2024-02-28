package com.proyectmanager.Services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    public String getToken(UserDetails user);
    
}
