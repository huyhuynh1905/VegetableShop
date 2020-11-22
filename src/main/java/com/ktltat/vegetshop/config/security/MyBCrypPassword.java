package com.ktltat.vegetshop.config.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */
public class MyBCrypPassword extends BCryptPasswordEncoder {
    public String hashPassword(String plaintextPass){
        return BCrypt.hashpw(plaintextPass, BCrypt.gensalt());
    }
    public boolean checkPassword(String plaintext, String hashtext){
        return BCrypt.checkpw(plaintext,hashtext);
    }
}
