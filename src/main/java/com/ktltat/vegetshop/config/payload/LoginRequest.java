package com.ktltat.vegetshop.config.payload;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 22/11/2020
 */
public class LoginRequest {

    private String email;
    private String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
