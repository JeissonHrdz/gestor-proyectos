package com.proyectmanager.Services.Impl;

import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Entity.AuthResponse;
import com.proyectmanager.Model.Entity.LoginRequest;
import com.proyectmanager.Services.IAuthService;

@Service
public  class AuthImpl implements IAuthService{

    @Override
    public AuthResponse login(LoginRequest request) {
        
        return null;
    }
    
}
