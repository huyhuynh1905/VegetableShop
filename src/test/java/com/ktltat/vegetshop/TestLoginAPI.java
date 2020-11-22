package com.ktltat.vegetshop;

import com.ktltat.vegetshop.config.payload.LoginRequest;
import com.ktltat.vegetshop.config.payload.LoginResponse;
import com.ktltat.vegetshop.config.security.CustomTaiKhoanDetails;
import com.ktltat.vegetshop.config.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


/**
 * @project: vegetshop
 * @author: HuyHuynh on 22/11/2020
 */
@RestController
@RequestMapping("/api")
public class TestLoginAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPass()));
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomTaiKhoanDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
    @GetMapping("/random")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public LoginResponse randomStuff(){
        return new LoginResponse("Test thành công!!");
    }

}