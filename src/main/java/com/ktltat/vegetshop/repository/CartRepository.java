package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface CartRepository extends JpaRepository<CartEntity,Integer> {
    List<CartEntity> findAllByIdtk(Integer idtk);
    CartEntity findAllByIdtkAndAndIdsp(Integer idtk, Integer idsp);
    void deleteByIdcart(Integer idcart);
    void deleteByIdtk(Integer idtk);
}
