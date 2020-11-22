package com.ktltat.vegetshop.service;

import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.SanPhamEntity;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface ISanPhamService {
    List<SanPhamDTO> findAllSanPham();
    SanPhamDTO addSanPham(SanPhamDTO sanPhamDTO);
    void updateSanPham(SanPhamDTO sanPhamDTO);
    void deleteSanPham(Integer id);
    void saveSanPham(SanPhamEntity sanPhamEntity);
    List<SanPhamDTO> findLoaiQua(Integer idloaisp);
    SanPhamDTO findByIdsp(Integer idsp);
}
