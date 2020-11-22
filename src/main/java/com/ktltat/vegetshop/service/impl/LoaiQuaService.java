package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.converter.LoaiQuaConverter;
import com.ktltat.vegetshop.dto.LoaiQuaDTO;
import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import com.ktltat.vegetshop.repository.LoaiQuaRepository;
import com.ktltat.vegetshop.service.ILoaiQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */

@Service
@Transactional
public class LoaiQuaService implements ILoaiQuaService {

    @Autowired
    private LoaiQuaRepository loaiQuaRepository;

    @Autowired
    private LoaiQuaConverter loaiQuaConverter;

    @Override
    public List<LoaiQuaDTO> findAllLoaiQua() {
        List<LoaiQuaEntity> loaiQuaEntities = loaiQuaRepository.findAll();
        List<LoaiQuaDTO> loaiQuaDTOS = loaiQuaConverter.asListDTO(loaiQuaEntities);
        return loaiQuaDTOS;
    }

    @Override
    public LoaiQuaDTO addLoaiQua(LoaiQuaDTO loaiQuaDTO) {
        LoaiQuaEntity loaiQuaEntity = loaiQuaConverter.toLoaiQuaEntity(loaiQuaDTO);
        loaiQuaEntity = loaiQuaRepository.save(loaiQuaEntity);
        return loaiQuaConverter.toLoaiQuaDTO(loaiQuaEntity);
    }

    @Override
    public void updateLoaiQua(LoaiQuaDTO loaiQuaDTO) {
        LoaiQuaEntity loaiQuaEntity = loaiQuaConverter.toLoaiQuaEntity(loaiQuaDTO);
        loaiQuaRepository.save(loaiQuaEntity);
    }

    @Override
    public void deleteLoaiQua(Integer idloaip) {
        loaiQuaRepository.deleteByIdloaisp(idloaip);
    }
}
