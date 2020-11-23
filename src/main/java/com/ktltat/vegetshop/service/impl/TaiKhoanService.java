package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.config.security.CustomTaiKhoanDetails;
import com.ktltat.vegetshop.config.security.MyBCrypPassword;
import com.ktltat.vegetshop.converter.TaiKhoanConverter;
import com.ktltat.vegetshop.dto.TaiKhoanDTO;
import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import com.ktltat.vegetshop.repository.TaiKhoanRepository;
import com.ktltat.vegetshop.service.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Service
@Transactional
public class TaiKhoanService implements ITaiKhoanService, UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private TaiKhoanConverter taiKhoanConverter;

    private MyBCrypPassword myBCrypPassword = new MyBCrypPassword();

    @Override
    public TaiKhoanDTO save(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanConverter.toTaiKhoanEntity(taiKhoanDTO);
        String hashPass = myBCrypPassword.hashPassword(taiKhoanEntity.getPass());
        taiKhoanEntity.setPass(hashPass);
        taiKhoanEntity = taiKhoanRepository.save(taiKhoanEntity);
        return taiKhoanConverter.toTaiKhoanDTO(taiKhoanEntity);
    }

    @Override
    public List<TaiKhoanDTO> getAllTaiKhoan() {
        List<TaiKhoanEntity> taiKhoanEntities = taiKhoanRepository.findAll();
        List<TaiKhoanDTO> taiKhoanDTOS = taiKhoanConverter.asListDTO(taiKhoanEntities);
        return taiKhoanDTOS;
    }

    @Override
    public void updateTaiKhoan(TaiKhoanEntity taiKhoanEntity) {
        String hashpass = myBCrypPassword.hashPassword(taiKhoanEntity.getPass());
        taiKhoanEntity.setPass(hashpass);
        taiKhoanRepository.save(taiKhoanEntity);
    }

    @Override
    public void deleteTaiKhoan(TaiKhoanEntity taiKhoanEntity) {
        taiKhoanRepository.delete(taiKhoanEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findTaiKhoanEntityByEmail(email);
        return new CustomTaiKhoanDetails(taiKhoanEntity);
    }

    @Override
    public void deleteTaiKhoanByIdtk(Integer idtk) {
        taiKhoanRepository.deleteByIdtk(idtk);
    }

    //Phương thưc ko từ interfaece
    public TaiKhoanEntity loadTaiKhoan(String email) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findTaiKhoanEntityByEmail(email);
        return taiKhoanEntity;
    }
    public TaiKhoanEntity findByIdtk(Integer idtk){
        return taiKhoanRepository.findByIdtk(idtk);
    }
}
