package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.TaiKhoanDTO;
import com.ktltat.vegetshop.entity.TaiKhoanEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
@Component
public class TaiKhoanConverter {
    public TaiKhoanDTO toTaiKhoanDTO(TaiKhoanEntity entity){
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        taiKhoanDTO.setIdtk(entity.getIdtk());
        taiKhoanDTO.setEmail(entity.getEmail());
        taiKhoanDTO.setPass(entity.getPass());
        taiKhoanDTO.setPhanquyen(entity.getPhanquyen());
        taiKhoanDTO.setPhone(entity.getPhone());
        taiKhoanDTO.setTentk(entity.getTentk());
        return taiKhoanDTO;
    }
    public TaiKhoanEntity toTaiKhoanEntity(TaiKhoanDTO taiKhoanDTO){
        TaiKhoanEntity entity = new TaiKhoanEntity();
        entity.setIdtk(taiKhoanDTO.getIdtk());
        entity.setEmail(taiKhoanDTO.getEmail());
        entity.setPass(taiKhoanDTO.getPass());
        entity.setPhanquyen(taiKhoanDTO.getPhanquyen());
        entity.setPhone(taiKhoanDTO.getPhone());
        entity.setTentk(taiKhoanDTO.getTentk());
        return entity;
    }

    public List<TaiKhoanDTO> asListDTO(List<TaiKhoanEntity> entities){
        List<TaiKhoanDTO> asListDTO = new ArrayList<>();
        for (TaiKhoanEntity entity : entities){
            asListDTO.add(toTaiKhoanDTO(entity));
        }
        return asListDTO;
    }

}
