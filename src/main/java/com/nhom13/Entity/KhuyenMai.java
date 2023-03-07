package com.nhom13.Entity;

import com.nhom13.DAO.KhuyenMaiDAO;
import java.util.Date;

public class KhuyenMai {

    private int id;
    private Date ngayApDung;
    private Date ngayKetThuc;
    private int giaTri;
    private String lyDo;
    private String maNv;

    public KhuyenMai(int id, int giaTri) {
        this.id = id;
        this.giaTri = giaTri;
    }

    public KhuyenMai(int id, Date ngayApDung, Date ngayKetThuc, int giaTri, String lyDo, String maNv) {
        this.id = id;
        this.ngayApDung = ngayApDung;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTri = giaTri;
        this.lyDo = lyDo;
        this.maNv = maNv;
    }

    public KhuyenMai() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "id=" + id + ", ngayApDung=" + ngayApDung + ", ngayKetThuc=" + ngayKetThuc + ", giaTri=" + giaTri + ", lyDo=" + lyDo + ", maNv=" + maNv + '}';
    }

}
