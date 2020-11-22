package com.ktltat.vegetshop.service;

import com.ktltat.vegetshop.dto.HoaDonDTO;
import com.ktltat.vegetshop.dto.LoaiQuaDTO;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface IHoaDonService {
    List<HoaDonDTO> findAllHoaDon();
    HoaDonDTO addHoaDon(HoaDonDTO hoaDonDTO);
    void updateHoaDon(HoaDonDTO hoaDonDTO);
    void deleteHoaDon(Integer idhd);
}
