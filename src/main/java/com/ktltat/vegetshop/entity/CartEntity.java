package com.ktltat.vegetshop.entity;

import javax.persistence.*;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 18/11/2020
 */
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcart")
    private int idcart;

    @Column(name = "idsp")
    private int idsp;

    @Column(name = "idtk")
    private int idtk;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "tonggia")
    private String tongiga;


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

    public String getTongiga() {
        return tongiga;
    }

    public void setTongiga(String tongiga) {
        this.tongiga = tongiga;
    }
}
