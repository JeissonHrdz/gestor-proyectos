package com.proyectmanager.Services;

import com.proyectmanager.Model.Entity.AuthResponse;
import com.proyectmanager.Model.Entity.LoginRequest;

public interface IAuthService {

    public AuthResponse login(LoginRequest request);    
    
}
