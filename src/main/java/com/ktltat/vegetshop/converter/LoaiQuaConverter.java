package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.LoaiQuaDTO;
import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */

@Component
public class LoaiQuaConverter {
    public LoaiQuaDTO toLoaiQuaDTO(LoaiQuaEntity entity){
        LoaiQuaDTO loaiQuaDTO = new LoaiQuaDTO();
        loaiQuaDTO.setLoaisp(entity.getLoaisp());
        loaiQuaDTO.setIdlsp(entity.getIdloaisp());
        return loaiQuaDTO;
    }
    public LoaiQuaEntity toLoaiQuaEntity(LoaiQuaDTO loaiQuaDTO){
        LoaiQuaEntity loaiQuaEntity = new LoaiQuaEntity();
        loaiQuaEntity.setLoaisp(loaiQuaDTO.getLoaisp());
        loaiQuaEntity.setIdloaisp(loaiQuaDTO.getIdlsp());
        return loaiQuaEntity;
    }

    public List<LoaiQuaDTO> asListDTO(List<LoaiQuaEntity> entityList){
        List<LoaiQuaDTO> asListDTO = new ArrayList<>();
        for (LoaiQuaEntity entity : entityList) {
            asListDTO.add(toLoaiQuaDTO(entity));
        }
        return asListDTO;
    }
}
