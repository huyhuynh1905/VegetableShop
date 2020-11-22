package com.ktltat.vegetshop.service;

import com.ktltat.vegetshop.dto.PhanLoaiDTO;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface IPhanLoaiService {
    List<PhanLoaiDTO> findAllPhanLoai();
    PhanLoaiDTO addPhanLoai(PhanLoaiDTO phanLoaiDTO);
    void updatePhanLoai(PhanLoaiDTO phanLoaiDTO);
    void deletePhanLoai(Integer id);
}
