package com.example.demo.security.services;


import com.example.demo.models.dto.auth.LoginRequest;
import com.example.demo.models.dto.auth.LoginResponse;
import com.example.demo.models.dto.auth.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
