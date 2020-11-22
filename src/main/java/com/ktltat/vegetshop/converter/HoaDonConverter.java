package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.HoaDonDTO;
import com.ktltat.vegetshop.entity.HoaDonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */

@Component
public class HoaDonConverter {
    public HoaDonDTO toHoaDonDTO(HoaDonEntity entity){
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        hoaDonDTO.setIdhd(entity.getIdhd());
        hoaDonDTO.setNgaythanhtoan(entity.getNgaythanhtoan());
        hoaDonDTO.setTongtien(entity.getTongtien());
        hoaDonDTO.setIdtk(entity.getIdtk());
        return hoaDonDTO;
    }
    public HoaDonEntity toHoaDonEntity(HoaDonDTO hoaDonDTO){
        HoaDonEntity hoaDonEntity = new HoaDonEntity();
        hoaDonEntity.setIdhd(hoaDonDTO.getIdhd());
        hoaDonEntity.setNgaythanhtoan(hoaDonDTO.getNgaythanhtoan());
        hoaDonEntity.setTongtien(hoaDonDTO.getTongtien());
        hoaDonEntity.setIdtk(hoaDonDTO.getIdtk());
        return hoaDonEntity;
    }

    public List<HoaDonDTO> asListDTO(List<HoaDonEntity> entityList){
        List<HoaDonDTO> asListDTO = new ArrayList<>();
        for (HoaDonEntity entity : entityList) {
            asListDTO.add(toHoaDonDTO(entity));
        }
        return asListDTO;
    }
}
