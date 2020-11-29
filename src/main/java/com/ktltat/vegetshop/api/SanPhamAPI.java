package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.PhanLoaiDTO;
import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.PhanLoaiEntity;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import com.ktltat.vegetshop.service.impl.PhanLoaiService;
import com.ktltat.vegetshop.service.impl.SanPhamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */

@CrossOrigin
@RestController
public class SanPhamAPI {

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private PhanLoaiService phanLoaiService;

    //Upload Sản Phẩm có image:
    @PostMapping(value = "/uploadsp")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<?> createEmployee(@RequestParam("tensp") String tensp,
                                     @RequestParam("giasp") String giasp
                                    , @RequestParam("thuonghieu") String thuonghieu
                                    , @RequestParam("tinhtrang") String tinhtrang
                                    , @RequestParam("nguongoc") String nguongoc
                                    , @RequestParam("khoiluong") String khoiluong
                                    , @RequestParam("chitiet") String chitiet
                                    , @RequestParam("loaisp") String loaisp
                                    , HttpServletRequest request
                                    , final @RequestParam("hinhanh") MultipartFile hinhanh){
        try {
            HttpHeaders headers = new HttpHeaders();
            String fileName = hinhanh.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            long size = hinhanh.getSize();

            // Save the file locally
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(hinhanh.getBytes());
            stream.close();

            SanPhamEntity sanPhamEntity = new SanPhamEntity();
            sanPhamEntity.setTensp(tensp);
            sanPhamEntity.setKhoiluong(khoiluong);
            sanPhamEntity.setNguongoc(nguongoc);
            sanPhamEntity.setGiasp(giasp);
            sanPhamEntity.setThuonghieu(thuonghieu);
            sanPhamEntity.setTinhtrang(tinhtrang);
            sanPhamEntity.setChitiet(chitiet);
            sanPhamEntity.setHinhanh(filePath);
            sanPhamService.saveSanPham(sanPhamEntity);
            log.info("Employee Created");
            headers.add("Employe Saved With Image - ", fileName);
            List<SanPhamDTO> sanPhamDTOS = sanPhamService.findAllSanPham();
            int sizeArr = sanPhamDTOS.size();
            //Xử lí loại thêm vào:
            String[] arrayList = loaisp.split("-");
            for (String x: arrayList) {
                if (x.equals("1")){
                    PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
                    phanLoaiDTO.setIdloaisp(Integer.parseInt(x));
                    phanLoaiDTO.setIdsp(sanPhamDTOS.get(sizeArr-1).getIdsp());
                    phanLoaiService.addPhanLoai(phanLoaiDTO);
                } else if (x.equals("2")){
                    PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
                    phanLoaiDTO.setIdloaisp(Integer.parseInt(x));
                    phanLoaiDTO.setIdsp(sanPhamDTOS.get(sizeArr-1).getIdsp());
                    phanLoaiService.addPhanLoai(phanLoaiDTO);
                } else if (x.equals("3")){
                    PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
                    phanLoaiDTO.setIdloaisp(Integer.parseInt(x));
                    phanLoaiDTO.setIdsp(sanPhamDTOS.get(sizeArr-1).getIdsp());
                    phanLoaiService.addPhanLoai(phanLoaiDTO);
                } else if (x.equals("4")){
                    PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
                    phanLoaiDTO.setIdloaisp(Integer.parseInt(x));
                    phanLoaiDTO.setIdsp(sanPhamDTOS.get(sizeArr-1).getIdsp());
                    phanLoaiService.addPhanLoai(phanLoaiDTO);
                }else if (x.equals("5")){
                    PhanLoaiDTO phanLoaiDTO = new PhanLoaiDTO();
                    phanLoaiDTO.setIdloaisp(Integer.parseInt(x));
                    phanLoaiDTO.setIdsp(sanPhamDTOS.get(sizeArr-1).getIdsp());
                    phanLoaiService.addPhanLoai(phanLoaiDTO);
                }
            }

            return new ResponseEntity<>(filePath+" Employe Saved With File - " + fileName, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception: " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/sanpham")
    public List<SanPhamDTO> getAllSanPham(){
        return sanPhamService.findAllSanPham();
    }

    @PostMapping(value = "/sanpham")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SanPhamDTO addSanPham(@RequestBody SanPhamDTO sanPhamDTO){
        return sanPhamService.addSanPham(sanPhamDTO);
    }

    @PutMapping(value = "/sanpham")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateSanPham(@RequestBody SanPhamDTO sanPhamDTO){
        sanPhamService.updateSanPham(sanPhamDTO);
    }

    @DeleteMapping(value = "/xoasanpham={idsp}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSanPham(@PathVariable Integer idsp){
        sanPhamService.deleteSanPham(idsp);
    }

    @GetMapping(value = "/sanphamloai{idloaisp}")
    public List<SanPhamDTO> findLoaiQua(@PathVariable Integer idloaisp){
        return sanPhamService.findLoaiQua(idloaisp);
    }

    @GetMapping(value = "/sanpham={idsp}")
    @PreAuthorize("permitAll()")
    public SanPhamDTO findByIdsp(@PathVariable Integer idsp){
        return sanPhamService.findByIdsp(idsp);
    }

}
