package com.ktltat.vegetshop.entity;

import javax.persistence.*;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */

@Entity
@Table(name = "phanloai")
public class PhanLoaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpl")
    private int idpl;

    @Column(name = "idsp")
    private int idsp;

    @Column(name = "idloaisp")
    private int idloaisp;

    public int getIdpl() {
        return idpl;
    }

    public void setIdpl(int idpl) {
        this.idpl = idpl;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getIdloaisp() {
        return idloaisp;
    }

    public void setIdloaisp(int idloaisp) {
        this.idloaisp = idloaisp;
    }
}
