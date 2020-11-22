package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.LoaiQuaDTO;
import com.ktltat.vegetshop.service.impl.LoaiQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */

@CrossOrigin
@RestController
public class LoaiQuaAPI {

    @Autowired
    private LoaiQuaService loaiQuaService;

    @GetMapping(value = "/loaiqua")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<LoaiQuaDTO> getAllLoaiQua(){
        return loaiQuaService.findAllLoaiQua();
    }

    @PostMapping(value = "/loaiqua")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public LoaiQuaDTO addLoaiQua(@RequestBody LoaiQuaDTO loaiQuaDTO){
        return loaiQuaService.addLoaiQua(loaiQuaDTO);
    }

    @PutMapping(value = "/loaiqua")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateLoaiQua(@RequestBody LoaiQuaDTO loaiQuaDTO){
        loaiQuaService.updateLoaiQua(loaiQuaDTO);
    }

    @DeleteMapping(value = "/loaiqua/{idloaisp}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteLoaiQua(@PathVariable Integer idsp){
        loaiQuaService.deleteLoaiQua(idsp);
    }
}
