package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.PhanLoaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface PhanLoaiRepository extends JpaRepository<PhanLoaiEntity,Integer> {
    void deleteByIdpl(Integer idpl);
}
