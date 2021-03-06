package com.ktltat.vegetshop;

import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import com.ktltat.vegetshop.service.impl.SanPhamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author: HuyHuynh on 21/11/2020
 */

@RestController
@CrossOrigin
public class TestAPI {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SanPhamService sanPhamService;

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    //Upload Sản Phẩm có image:
    @PostMapping(value = "/testthoi")
    public @ResponseBody
    ResponseEntity<?> createEmployee(@RequestParam("tensp") String tensp,
                                     @RequestParam("giasp") String giasp
            , @RequestParam("thuonghieu") String thuonghieu
            , @RequestParam("tinhtrang") String tinhtrang
            , @RequestParam("nguongoc") String nguongoc
            , @RequestParam("khoiluong") String khoiluong
            , @RequestParam("chitiet") String chitiet
            , HttpServletRequest request
            , @RequestParam("hinhanh") MultipartFile hinhanh){
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
            return new ResponseEntity<>(filePath+" Employe Saved With File - " + fileName, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception: " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/sanphamloai{idloaisp}")
    public List<SanPhamDTO> findLoaiQua(@PathVariable Integer idloaisp){

        return sanPhamService.findLoaiQua(idloaisp);
    }
}
