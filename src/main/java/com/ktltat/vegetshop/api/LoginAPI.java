package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.config.payload.LoginRequest;
import com.ktltat.vegetshop.config.payload.LoginResponse;
import com.ktltat.vegetshop.config.security.CustomTaiKhoanDetails;
import com.ktltat.vegetshop.config.security.JwtTokenProvider;
import com.ktltat.vegetshop.dto.TaiKhoanDTO;
import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import com.ktltat.vegetshop.service.impl.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
@CrossOrigin
@RestController
public class LoginAPI {

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping(value = "/adduser")
    public TaiKhoanDTO addTaiKhoan (@RequestBody TaiKhoanDTO taiKhoanDTO){
        taiKhoanDTO.setPhanquyen(0);
        return taiKhoanService.save(taiKhoanDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication;
        TaiKhoanEntity taiKhoanEntity;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPass()));
            taiKhoanEntity = taiKhoanService.loadTaiKhoan(loginRequest.getEmail());
        } catch (Exception ex){
            return (ResponseEntity<?>) ResponseEntity.status(500);
        }
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomTaiKhoanDetails) authentication.getPrincipal());
        LoginResponse loginResponse = new LoginResponse(jwt);
        loginResponse.setEmail(taiKhoanEntity.getEmail());
        loginResponse.setIdtk(taiKhoanEntity.getIdtk());
        loginResponse.setTentk(taiKhoanEntity.getPhone());
        loginResponse.setPhone(taiKhoanEntity.getPhone());
        loginResponse.setPhanquyen(taiKhoanEntity.getPhanquyen());
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(value = "/getalltaikhoan")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<TaiKhoanDTO> getAllTaiKhoan(){
        return taiKhoanService.getAllTaiKhoan();
    }

    @PutMapping(value = "/updatetaikhoan")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateTaiKhoan(@RequestBody TaiKhoanEntity taiKhoanEntity){
        TaiKhoanEntity entity = taiKhoanService.findByIdtk(taiKhoanEntity.getIdtk());
        taiKhoanEntity.setPass(entity.getPass());
        taiKhoanService.updateTaiKhoan(taiKhoanEntity);
    }

    @DeleteMapping(value = "/deletetaikhoan={idtk}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteTaiKhoan(@PathVariable Integer idtk){
        taiKhoanService.deleteTaiKhoanByIdtk(idtk);
    }

    /*@PostMapping(value = "/loginpage")
    public TaiKhoanEntity loginPage(@RequestParam("email") String email, @RequestParam("pass") String pass){
        return taiKhoanService.login(email,pass);
    }*/
}
