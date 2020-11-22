package com.ktltat.vegetshop.dto;

import javax.persistence.Column;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public class LoaiQuaDTO {

    private int idlsp;
    private String loaisp;

    public int getIdlsp() {
        return idlsp;
    }

    public void setIdlsp(int idlsp) {
        this.idlsp = idlsp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }
}
