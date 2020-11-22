package com.ktltat.vegetshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Entity
@Table(name = "taikhoan")
public class TaiKhoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtk")
    private int idtk;

    @Column(name = "tentk")
    private String tentk;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pass")
    private String pass;

    @Column(name = "phanquyen")
    private int phanquyen;

//    @OneToMany(mappedBy = "tkhoan")
//    private List<HoaDonEntity> hoaDonEntityList = new ArrayList<>();
//
//    @ManyToMany(mappedBy = "taiKhoans")
//    private List<SanPhamEntity> sanPhams = new ArrayList<>();

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }

}
