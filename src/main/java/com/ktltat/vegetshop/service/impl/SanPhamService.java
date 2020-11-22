package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.converter.SanPhamConverter;
import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.LoaiQuaEntity;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import com.ktltat.vegetshop.repository.SanPhamRepository;
import com.ktltat.vegetshop.service.ISanPhamService;
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
public class SanPhamService implements ISanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamConverter sanPhamConverter;

    @Override
    public List<SanPhamDTO> findAllSanPham() {
        List<SanPhamEntity> sanPhamEntities = sanPhamRepository.findAll();
        List<SanPhamDTO> dtoList = sanPhamConverter.asListDTO(sanPhamEntities);
        return dtoList;
    }

    @Override
    public SanPhamDTO addSanPham(SanPhamDTO sanPhamDTO) {
        SanPhamEntity sanPhamEntity = sanPhamConverter.toSanPhamEntity(sanPhamDTO);
        sanPhamEntity = sanPhamRepository.save(sanPhamEntity);
        return sanPhamConverter.toSanPhamDTO(sanPhamEntity);
    }

    @Override
    public void updateSanPham(SanPhamDTO sanPhamDTO) {
        SanPhamEntity sanPhamEntity = sanPhamConverter.toSanPhamEntity(sanPhamDTO);
        sanPhamRepository.save(sanPhamEntity);
    }

    @Override
    public void deleteSanPham(Integer idsp) {
        sanPhamRepository.deleteByIdsp(idsp);
    }

    @Override
    public void saveSanPham(SanPhamEntity sanPhamEntity) {
        sanPhamRepository.save(sanPhamEntity);
    }

    @Override
    public List<SanPhamDTO> findLoaiQua(Integer idloaisp){
        LoaiQuaEntity loaiQuaEntity = new LoaiQuaEntity();
        loaiQuaEntity.setIdloaisp(idloaisp);
        List<SanPhamEntity> sanPhamEntities = sanPhamRepository.findAllByLoaiQuas(loaiQuaEntity);
        List<SanPhamDTO> sanPhamDTOS = sanPhamConverter.asListDTO(sanPhamEntities);
        return sanPhamDTOS;
    }

    @Override
    public SanPhamDTO findByIdsp(Integer idsp) {
        SanPhamEntity sanPhamEntity = sanPhamRepository.findByIdsp(idsp);
        return sanPhamConverter.toSanPhamDTO(sanPhamEntity);
    }


}
