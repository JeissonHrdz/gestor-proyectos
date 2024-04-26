package com.proyectmanager.Services;



import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Entity.AuthResponse;
import com.proyectmanager.Model.Entity.LoginRequest;

@Service
public interface IAuthService {

    public AuthResponse login(LoginRequest request);    
    
}
