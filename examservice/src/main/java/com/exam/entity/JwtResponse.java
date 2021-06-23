package com.exam.entity;

public class JwtResponse {
    String Token;

    public JwtResponse(String token) {
        Token = token;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
