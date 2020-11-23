package com.ktltat.vegetshop.dto;

import javax.persistence.Column;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public class CartDTO {

    private int idcart;
    private int idsp;
    private int idtk;
    private int soluong;
    private String tonggia;

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTonggia() {
        return tonggia;
    }

    public void setTonggia(String tonggia) {
        this.tonggia = tonggia;
    }
}
