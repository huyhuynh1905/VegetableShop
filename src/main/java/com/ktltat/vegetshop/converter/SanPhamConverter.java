package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
@Component
public class SanPhamConverter {
    public SanPhamDTO toSanPhamDTO(SanPhamEntity entity){
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setIdsp(entity.getIdsp());
        sanPhamDTO.setChitiet(entity.getChitiet());
        sanPhamDTO.setGiasp(entity.getGiasp());
        sanPhamDTO.setHinhanh(entity.getHinhanh());
        sanPhamDTO.setKhoiluong(entity.getKhoiluong());
        sanPhamDTO.setNguongoc(entity.getNguongoc());
        sanPhamDTO.setTensp(entity.getTensp());
        sanPhamDTO.setThuonghieu(entity.getThuonghieu());
        sanPhamDTO.setTinhtrang(entity.getTinhtrang());
        return sanPhamDTO;
    }
    public SanPhamEntity toSanPhamEntity(SanPhamDTO sanPhamDTO){
        SanPhamEntity sanPhamEntity = new SanPhamEntity();
        sanPhamEntity.setIdsp(sanPhamDTO.getIdsp());
        sanPhamEntity.setChitiet(sanPhamDTO.getChitiet());
        sanPhamEntity.setGiasp(sanPhamDTO.getGiasp());
        sanPhamEntity.setHinhanh(sanPhamDTO.getHinhanh());
        sanPhamEntity.setKhoiluong(sanPhamDTO.getKhoiluong());
        sanPhamEntity.setNguongoc(sanPhamDTO.getNguongoc());
        sanPhamEntity.setTensp(sanPhamDTO.getTensp());
        sanPhamEntity.setThuonghieu(sanPhamDTO.getThuonghieu());
        sanPhamEntity.setTinhtrang(sanPhamDTO.getTinhtrang());
        return sanPhamEntity;
    }

    public List<SanPhamDTO> asListDTO(List<SanPhamEntity> entityList){
        List<SanPhamDTO> asListDTO = new ArrayList<>();
        for (SanPhamEntity entity : entityList) {
            asListDTO.add(toSanPhamDTO(entity));
        }
        return asListDTO;
    }
}
