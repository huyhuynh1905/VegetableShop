package com.ktltat.vegetshop.service;


import com.ktltat.vegetshop.dto.LoaiQuaDTO;
import com.ktltat.vegetshop.entity.LoaiQuaEntity;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface ILoaiQuaService {
    List<LoaiQuaDTO> findAllLoaiQua();
    LoaiQuaDTO addLoaiQua(LoaiQuaDTO loaiQuaDTO);
    void updateLoaiQua(LoaiQuaDTO loaiQuaDTO);
    void deleteLoaiQua(Integer id);
}
