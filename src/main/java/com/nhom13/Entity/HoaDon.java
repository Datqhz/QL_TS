package com.nhom13.Entity;

import java.sql.Date;
import java.util.List;

public class HoaDon {

    private int id;
    private String hinhThucThanhToan;
    private Date ngayLap;
    private double thanhTien;
    private int idBan;
    private String idNhanVien;
    private int idKhuyenMai;
    private int idKhachHang;
    List<ChiTietHoaDon> foodList;

    public HoaDon() {
    }

    public HoaDon(int id, String hinhThucThanhToan, Date ngayLap, double thanhTien, int idBan, String idNhanVien, int idKhuyenMai, int idKhachHang) {
        this.id = id;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
        this.idBan = idBan;
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

    public double getThanhTien() {
        return thanhTien;
    }

    public int getIdBan() {
        return idBan;
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

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
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

    public List<ChiTietHoaDon> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<ChiTietHoaDon> FoodList) {
        this.foodList = FoodList;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", hinhThucThanhToan=" + hinhThucThanhToan + ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + ", idBan=" + idBan + ", idNhanVien=" + idNhanVien + ", idKhuyenMai=" + idKhuyenMai + ", idKhachHang=" + idKhachHang + '}';
    }

}
