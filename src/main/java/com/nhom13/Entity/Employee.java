
package com.nhom13.Entity;


public class Employee {
    private String maNV;
    private String firstName;
    private String lastName;
    private String account;
    private String password;
    private String sdt;
    private int role;
    private boolean status;
    
    //Constructor

    public Employee() {
    }

    public Employee(String maNV, String firstName, String lastName, String account, String password, String sdt, int role, boolean status) {
        this.maNV = maNV;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
        this.sdt = sdt;
        this.role = role;
        this.status = status;
    }
    
    
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}
