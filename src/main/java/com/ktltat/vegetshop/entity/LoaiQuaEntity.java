package com.ktltat.vegetshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Entity
@Table(name = "loaiqua")
public class LoaiQuaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloaisp")
    private int idloaisp;

    @Column(name = "typeveget")
    private String loaisp;

    @ManyToMany(mappedBy = "loaiQuas")
    private List<SanPhamEntity> sanPhams = new ArrayList<>();

    public int getIdloaisp() {
        return idloaisp;
    }

    public void setIdloaisp(int idloaisp) {
        this.idloaisp = idloaisp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public List<SanPhamEntity> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPhamEntity> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
