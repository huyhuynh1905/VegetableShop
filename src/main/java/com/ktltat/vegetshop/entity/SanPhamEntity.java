package com.ktltat.vegetshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Entity
@Table(name = "sanpham")
public class SanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsp")
    private int idsp;

    @Column(name = "tensp")
    private String tensp;
    @Column(name = "giasp")
    private String giasp;
    @Column(name = "thuonghieu")
    private String thuonghieu;
    @Column(name = "tinhtrang")
    private String tinhtrang;
    @Column(name = "nguongoc")
    private String nguongoc;
    @Column(name = "khoiluong")
    private String khoiluong;
    @Column(name = "chitiet")
    private String chitiet;
    @Column(name = "hinhanh")
    private String hinhanh;

    @ManyToMany
    @JoinTable(name = "phanloai",
                joinColumns = @JoinColumn(name = "idsp"),
                inverseJoinColumns = @JoinColumn(name = "idloaisp"))
    private List<LoaiQuaEntity> loaiQuas = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "cart",
//            joinColumns = @JoinColumn(name = "idsp"),
//            inverseJoinColumns = @JoinColumn(name = "idtk"))
//    private List<TaiKhoanEntity> taiKhoans = new ArrayList<>();

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNguongoc() {
        return nguongoc;
    }

    public void setNguongoc(String nguongoc) {
        this.nguongoc = nguongoc;
    }

    public String getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(String khoiluong) {
        this.khoiluong = khoiluong;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public List<LoaiQuaEntity> getLoaiQuas() {
        return loaiQuas;
    }

    public void setLoaiQuas(List<LoaiQuaEntity> loaiQuas) {
        this.loaiQuas = loaiQuas;
    }

}
