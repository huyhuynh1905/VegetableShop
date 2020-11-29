package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.converter.HoaDonConverter;
import com.ktltat.vegetshop.dto.HoaDonDTO;
import com.ktltat.vegetshop.dto.LoaiQuaDTO;
import com.ktltat.vegetshop.entity.CartEntity;
import com.ktltat.vegetshop.entity.HoaDonEntity;
import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import com.ktltat.vegetshop.repository.CartRepository;
import com.ktltat.vegetshop.repository.HoaDonRepository;
import com.ktltat.vegetshop.service.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */

@Service
@Transactional
public class HoaDonService implements IHoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HoaDonConverter hoaDonConverter;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<HoaDonDTO> findAllHoaDon() {
        List<HoaDonEntity> hoaDonEntities = hoaDonRepository.findAll();
        List<HoaDonDTO> hoaDonDTOS = hoaDonConverter.asListDTO(hoaDonEntities);
        return hoaDonDTOS;
    }

    @Override
    public HoaDonDTO addHoaDon(HoaDonDTO hoaDonDTO) {
        HoaDonEntity hoaDonEntity = hoaDonConverter.toHoaDonEntity(hoaDonDTO);
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        hoaDonEntity.setNgaythanhtoan(sqlDate);
        List<CartEntity> cartEntities = cartRepository.findAllByIdtk(hoaDonDTO.getIdtk());
        double tonggia = 0;
        for (CartEntity cartEntity : cartEntities){
            double giatien = Double.parseDouble(cartEntity.getTongiga());
            tonggia+=giatien;
        }
        hoaDonEntity.setTongtien(String.valueOf(tonggia));
        hoaDonEntity = hoaDonRepository.save(hoaDonEntity);
        //Xoá danh sách của hoá đơn người dùng sau khi đã được thanh toán
        cartRepository.deleteByIdtk(hoaDonDTO.getIdtk());
        return hoaDonConverter.toHoaDonDTO(hoaDonEntity);
    }

    @Override
    public void updateHoaDon(HoaDonDTO hoaDonDTO) {
        HoaDonEntity hoaDonEntity = hoaDonConverter.toHoaDonEntity(hoaDonDTO);
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        hoaDonEntity.setNgaythanhtoan(sqlDate);
        hoaDonRepository.save(hoaDonEntity);
    }

    @Override
    public void deleteHoaDon(Integer idhd) {
        hoaDonRepository.deleteByIdhd(idhd);
    }
}
