/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.Entity;

/**
 *
 * @author thuan
 */
public class ChiTietHoaDon {
    private int id ;
    private int idHoaDon ;
    private int idMonAn;
    private int soLuong ;
    private int gia; 

    public ChiTietHoaDon(int id, int idHoaDon, int idMonAn, int soLuong, int gia) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public ChiTietHoaDon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "ChiTetHoaDon{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idMonAn=" + idMonAn + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }
    
}
