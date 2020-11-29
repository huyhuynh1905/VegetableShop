package com.ktltat.vegetshop.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Entity
@Table(name = "hoadon")
public class HoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhd")
    private int idhd;

    @Column(name = "tongtien")
    private String tongtien;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaythanhtoan")
    private Date ngaythanhtoan;

    @Column(name = "idtk")
    private int idtk;

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(Date ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }
}
