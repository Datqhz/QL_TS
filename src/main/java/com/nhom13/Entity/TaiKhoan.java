
package com.nhom13.Entity;

public class TaiKhoan {
    private int id;
    private String account;
    private String password;
    private boolean trangThai;
    private String manv;

    public TaiKhoan() {
    }

    
    public TaiKhoan(String account, String password, boolean trangThai, String manv) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.trangThai = trangThai;
        this.manv = manv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "id=" + id + ", account=" + account + ", password=" + password + ", trangThai=" + trangThai + ", manv=" + manv + '}';
    }
    
    
}
