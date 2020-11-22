package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.HoaDonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface HoaDonRepository extends JpaRepository<HoaDonEntity,Integer> {
    void deleteByIdhd(Integer idhd);
}
