package com.unibuc.cookbook.security.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String numeUtilizator;

    public JwtResponse(String accessToken, String username) {
        this.token = accessToken;
        this.numeUtilizator = username;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }
}