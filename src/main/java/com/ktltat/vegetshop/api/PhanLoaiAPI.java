package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.PhanLoaiDTO;
import com.ktltat.vegetshop.service.impl.PhanLoaiService;
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
public class PhanLoaiAPI {
    @Autowired
    private PhanLoaiService phanLoaiService;

    @GetMapping(value = "/phanloai")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<PhanLoaiDTO> getAllLoaiQua(){
        return phanLoaiService.findAllPhanLoai();
    }

    @PostMapping(value = "/phanloai")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PhanLoaiDTO addLoaiQua(@RequestBody PhanLoaiDTO phanLoaiDTO){
        return phanLoaiService.addPhanLoai(phanLoaiDTO);
    }

    @PutMapping(value = "/phanloai")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateLoaiQua(@RequestBody PhanLoaiDTO phanLoaiDTO){
        phanLoaiService.updatePhanLoai(phanLoaiDTO);
    }

    @DeleteMapping(value = "/phanloai/{idpl}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteLoaiQua(@PathVariable Integer idpl){
        phanLoaiService.deletePhanLoai(idpl);
    }
}
