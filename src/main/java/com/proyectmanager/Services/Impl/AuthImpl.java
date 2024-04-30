package com.proyectmanager.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.UserDao;
import com.proyectmanager.Model.Entity.AuthResponse;
import com.proyectmanager.Model.Entity.LoginRequest;
import com.proyectmanager.Services.IAuthService;
import com.proyectmanager.Services.IJwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthImpl implements IAuthService {

  @Autowired
  private final UserDao userDao;

  private final IJwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Override
  public AuthResponse login(LoginRequest request) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    UserDetails user = userDao.findByUsername(request.getUsername()).orElseThrow();
    String token = jwtService.getToken(user);
    System.out.println(token);
    return AuthResponse.builder()
        .token(token)
        .build();

  }

}
