package com.ktltat.vegetshop.service;

import com.ktltat.vegetshop.dto.TaiKhoanDTO;
import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */
public interface ITaiKhoanService {
    TaiKhoanDTO save(TaiKhoanDTO taiKhoanDTO);
    //TaiKhoanEntity login(String email,String pass);
    List<TaiKhoanDTO> getAllTaiKhoan();
    void updateTaiKhoan(TaiKhoanEntity taiKhoanEntity);
    void deleteTaiKhoan(TaiKhoanEntity taiKhoanEntity);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
    void deleteTaiKhoanByIdtk(Integer idtk);
}
