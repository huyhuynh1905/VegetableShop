package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.PhanLoaiDTO;
import com.ktltat.vegetshop.entity.PhanLoaiEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */

@Component
public class PhanLoaiConverter {
    public PhanLoaiDTO toPhanLoaiDTO(PhanLoaiEntity entity){
        PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
        phanLoaiDTO.setIdloaisp(entity.getIdloaisp());
        phanLoaiDTO.setIdsp(entity.getIdsp());
        return phanLoaiDTO;
    }
    public PhanLoaiEntity toPhanLoaiEntity(PhanLoaiDTO phanLoaiDTO){
        PhanLoaiEntity phanLoaiEntity = new PhanLoaiEntity();
        phanLoaiEntity.setIdloaisp(phanLoaiDTO.getIdloaisp());
        phanLoaiEntity.setIdsp(phanLoaiDTO.getIdsp());
        return phanLoaiEntity;
    }

    public List<PhanLoaiDTO> asListDTO(List<PhanLoaiEntity> entityList){
        List<PhanLoaiDTO> asListDTO = new ArrayList<>();
        for (PhanLoaiEntity entity : entityList) {
            asListDTO.add(toPhanLoaiDTO(entity));
        }
        return asListDTO;
    }
}
