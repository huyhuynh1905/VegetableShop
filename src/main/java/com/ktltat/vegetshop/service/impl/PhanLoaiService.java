package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.converter.PhanLoaiConverter;
import com.ktltat.vegetshop.dto.PhanLoaiDTO;
import com.ktltat.vegetshop.entity.PhanLoaiEntity;
import com.ktltat.vegetshop.repository.PhanLoaiRepository;
import com.ktltat.vegetshop.service.IPhanLoaiService;
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
public class PhanLoaiService implements IPhanLoaiService {
    @Autowired
    private PhanLoaiRepository phanLoaiRepository;

    @Autowired
    private PhanLoaiConverter phanLoaiConverter;


    @Override
    public List<PhanLoaiDTO> findAllPhanLoai() {
        List<PhanLoaiEntity> phanLoaiEntities = phanLoaiRepository.findAll();
        List<PhanLoaiDTO> phanLoaiDTOS = phanLoaiConverter.asListDTO(phanLoaiEntities);
        return phanLoaiDTOS;
    }

    @Override
    public PhanLoaiDTO addPhanLoai(PhanLoaiDTO phanLoaiDTO) {
        PhanLoaiEntity phanLoaiEntity = phanLoaiConverter.toPhanLoaiEntity(phanLoaiDTO);
        phanLoaiEntity = phanLoaiRepository.save(phanLoaiEntity);
        return phanLoaiConverter.toPhanLoaiDTO(phanLoaiEntity);
    }

    @Override
    public void updatePhanLoai(PhanLoaiDTO phanLoaiDTO) {
        PhanLoaiEntity phanLoaiEntity = phanLoaiConverter.toPhanLoaiEntity(phanLoaiDTO);
        phanLoaiRepository.save(phanLoaiEntity);
    }

    @Override
    public void deletePhanLoai(Integer id) {
        phanLoaiRepository.deleteByIdpl(id);
    }
}
