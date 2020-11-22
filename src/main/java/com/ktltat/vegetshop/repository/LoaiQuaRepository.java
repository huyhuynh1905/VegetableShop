package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface LoaiQuaRepository extends JpaRepository<LoaiQuaEntity,Integer> {
    void deleteByIdloaisp(Integer idloaisp);
}
