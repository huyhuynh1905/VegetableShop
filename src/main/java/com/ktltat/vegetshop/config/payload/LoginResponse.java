package com.ktltat.vegetshop.config.payload;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 22/11/2020
 */
public class LoginResponse {

    private String jwt;

    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
