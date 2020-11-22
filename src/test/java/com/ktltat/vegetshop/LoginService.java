package com.ktltat.vegetshop;

import com.ktltat.vegetshop.config.security.CustomTaiKhoanDetails;
import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import com.ktltat.vegetshop.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 22/11/2020
 */

@Transactional
@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findTaiKhoanEntityByEmail(email);
        return new CustomTaiKhoanDetails(taiKhoanEntity);
    }
}
