package com.nhom13.Entity;

public class Employee {

    private String maNV;
    private String firstName;
    private String lastName;
    private String sdt;
    private int role;
    private String gioiTinh;
    private TaiKhoan account;

    //Constructor
    public Employee() {
    }

//    public Employee(String maNV, String firstName, String lastName, String sdt, int role, String gioiTinh) {
//        this.maNV = maNV;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.sdt = sdt;
//        this.role = role;
//        this.gioiTinh = gioiTinh;
//    }
//    public Employee(String firstName, String lastName, String sdt, int role, String gioiTinh) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.sdt = sdt;
//        this.role = role;
//        this.gioiTinh = gioiTinh;
//    }
    public Employee(String maNV, String firstName, String lastName, String sdt, int role, String gioiTinh) {
        this.maNV = maNV;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sdt = sdt;
        this.role = role;
        this.gioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public TaiKhoan getAccount() {
        return account;
    }

    public void setAccount(TaiKhoan account) {
        this.account = account;
    }

//    public Employee(String maNV, String firstName, String lastName,  String sdt, int role) {
//        this.maNV = maNV;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.sdt = sdt;
//        this.role = role;
//    }
//    
    //Getter and setter
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "maNV=" + maNV + ", firstName=" + firstName + ", lastName=" + lastName + ", sdt=" + sdt + ", role=" + role + ", gioiTinh=" + gioiTinh + '}';
    }

}
