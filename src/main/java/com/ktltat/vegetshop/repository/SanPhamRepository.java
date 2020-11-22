package com.ktltat.vegetshop.repository;

import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface SanPhamRepository extends JpaRepository<SanPhamEntity,Integer> {
    void deleteByIdsp(Integer idsp);

//    @Query(value = "SELECT * " +
//            "FROM" +
//            " sanpham as sp" +
//            " INNER JOIN phanloai as pl ON sp.idsp = pl.idsp" +
//            " INNER JOIN loaiqua as lq ON pl.idloaisp = lq.idloaisp" +
//            " WHERE lq.idloaisp = 3", nativeQuery = true)
    List<SanPhamEntity> findAllByLoaiQuas(LoaiQuaEntity idloaisp);
    SanPhamEntity findByIdsp(Integer idsp);

}
