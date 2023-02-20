/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.Entity;

/**
 *
 * @author thuan
 */
public class LoaiMon {
    private int id ;
    private String ten ;
    private String maNv;

    public LoaiMon() {
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }
    

    public LoaiMon(int id, String ten , String maNv ) {
        this.id = id;
        this.ten = ten;
        this.maNv = maNv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "LoaiMon{" + "id=" + id + ", ten=" + ten + ", maNv=" + maNv + '}';
    }
    
    
}
