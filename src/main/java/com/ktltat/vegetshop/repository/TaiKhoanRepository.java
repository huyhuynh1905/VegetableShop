package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity,Integer> {
    TaiKhoanEntity findTaiKhoanEntityByEmail(String email);
    List<TaiKhoanEntity> findAll();
    TaiKhoanEntity findByIdtk(Integer idtk);
    void deleteByIdtk(Integer idtk);
}
