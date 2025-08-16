package com.barryzeha.apirestchallenge.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class UserWithToken {
    private String id;
    private String userName;
    private String token;

    public UserWithToken(String id, String userName, String token) {
        this.id = id;
        this.userName = userName;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
