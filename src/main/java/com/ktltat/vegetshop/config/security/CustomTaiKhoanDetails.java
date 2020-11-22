package com.ktltat.vegetshop.config.security;

import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 22/11/2020
 */

public class CustomTaiKhoanDetails implements UserDetails {

    private TaiKhoanEntity taiKhoanEntity;

    public CustomTaiKhoanDetails(TaiKhoanEntity taiKhoanEntity) {
        this.taiKhoanEntity = taiKhoanEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (taiKhoanEntity.getPhanquyen()==1) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return taiKhoanEntity.getPass();
    }

    @Override
    public String getUsername() {
        return taiKhoanEntity.getEmail();
    }

    public TaiKhoanEntity getTaiKhoanEntity() {
        return taiKhoanEntity;
    }

    public void setTaiKhoanEntity(TaiKhoanEntity taiKhoanEntity) {
        this.taiKhoanEntity = taiKhoanEntity;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
