package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.HoaDonDTO;
import com.ktltat.vegetshop.service.impl.HoaDonService;
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
public class HoaDonAPI {
    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping(value = "/hoadon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<HoaDonDTO> getAllHoaDon(){
        return hoaDonService.findAllHoaDon();
    }

    @PostMapping(value = "/hoadon")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public HoaDonDTO addHoaDon(@RequestBody HoaDonDTO hoaDonDTO){
        return hoaDonService.addHoaDon(hoaDonDTO);
    }

    @PutMapping(value = "/hoadon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateHoaDon(@RequestBody HoaDonDTO hoaDonDTO){
        hoaDonService.updateHoaDon(hoaDonDTO);
    }

    @DeleteMapping(value = "/hoadon/{idhd}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteHoaDon(@PathVariable Integer idhd){
        hoaDonService.deleteHoaDon(idhd);
    }
}
