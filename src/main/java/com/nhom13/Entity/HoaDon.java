/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.Entity;

import java.sql.Date;

/**
 *
 * @author thuan
 */
public class HoaDon {
    
    private int id ;
    private String hinhThucThanhToan;
    private Date ngayLap ;
    private int thanhTien ;
    private String tenBan ;
    private String idNhanVien ;
    private int idKhuyenMai;
    private int idKhachHang;

    public HoaDon() {
    }

    public HoaDon(int id, String hinhThucThanhToan, Date ngayLap, int thanhTien, String tenBan, String idNhanVien, int idKhuyenMai, int idKhachHang) {
        this.id = id;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
        this.tenBan = tenBan;
        this.idNhanVien = idNhanVien;
        this.idKhuyenMai = idKhuyenMai;
        this.idKhachHang = idKhachHang;
    }

    public int getId() {
        return id;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public String getTenBan() {
        return tenBan;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public int getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public void setIdKhuyenMai(int idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", hinhThucThanhToan=" + hinhThucThanhToan + ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + ", tenBan=" + tenBan + ", idNhanVien=" + idNhanVien + ", idKhuyenMai=" + idKhuyenMai + ", idKhachHang=" + idKhachHang + '}';
    }
    
    
    
}
