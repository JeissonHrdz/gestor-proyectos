package com.proyectmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Model.Entity.AuthResponse;
import com.proyectmanager.Model.Entity.LoginRequest;
import com.proyectmanager.Services.IAuthService;

@RestController
@RequestMapping("/app")
public class LoginController {

    @Autowired
    private  IAuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    
}
