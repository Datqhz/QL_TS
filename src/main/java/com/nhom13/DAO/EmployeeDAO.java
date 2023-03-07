package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    public Employee findEmployeeByID(String manv) throws Exception {
        String sql = "SELECT * FROM NHANVIEN WHERE MA_NV = ? ";

        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement emp = con.prepareStatement(sql);) {

            emp.setString(1, manv);
            ResultSet result = emp.executeQuery();

            while (result.next()) {
                Employee temp = new Employee();
                temp.setMaNV(result.getString(1));
                temp.setFirstName(result.getString(2));
                temp.setLastName(result.getString(3));
                temp.setSdt(result.getString(4));
                temp.setRole(result.getInt(5));
                temp.setGioiTinh(result.getString(6));
                return temp;
            }
            return null;
        }
    }

    public void saveEmployee(Employee employee) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String sdt = employee.getSdt();
            int idRole = employee.getRole();
            String sql = "INSERT INTO NHANVIEN(MA_NV , HO , TEN, SDT ,ID_VAI_TRO,GIOI_TINH)"
                    + "VALUES(? , ? , ? ,?,?,?)";
            statement = con.prepareCall(sql);
            statement.setString(1, maNV);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, sdt);
            statement.setInt(5, idRole);
            statement.setString(6, employee.getGioiTinh());
            statement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String sdt = employee.getSdt();
            int idRole = employee.getRole();
            String sql = "UPDATE NHANVIEN SET  HO = ? , TEN = ?,"
                    + "SDT = ? , ID_VAI_TRO = ?  , GIOI_TINH = ? WHERE MA_NV = ? ";
            String sql2 = "UPDATE TAIKHOAN SET TRANG_THAI =? WHERE ACCOUNT =?";
            statement = con.prepareCall(sql);
            statement.setString(6, maNV);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, sdt);
            statement.setInt(4, idRole);
            statement.setString(5, employee.getGioiTinh());
            statement.executeUpdate();
            statement = con.prepareCall(sql2);
            statement.setBoolean(1, employee.getAccount().isTrangThai());
            statement.setString(2, employee.getAccount().getAccount());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();

            String sql = "DELETE FROM NHANVIEN WHERE MA_NV = ?1";
            statement = con.prepareCall(sql);
            statement.setString(1, employee.getMaNV());
            statement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> findAll() throws Exception {
        List<Employee> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT NV.MA_NV, HO, TEN, SDT, ID_VAI_TRO, GIOI_TINH, TK.ID_TK, ACCOUNT, PASSWORD, TRANG_THAI "
                    + "FROM  NHANVIEN NV, TAIKHOAN TK WHERE NV.MA_NV = TK.MA_NV";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setMaNV(resultset.getString(1));
                employee.setFirstName(resultset.getString(2));
                employee.setLastName(resultset.getString(3));
                employee.setSdt(resultset.getString(4));
                employee.setRole(Integer.parseInt(resultset.getString(5)));
                employee.setGioiTinh(resultset.getString(6));
                TaiKhoan acc = new TaiKhoan();
                acc.setId(resultset.getInt(7));
                acc.setAccount(resultset.getString(8));
                acc.setPassword(resultset.getString(9));
                acc.setTrangThai(resultset.getBoolean(10));
                acc.setManv(employee.getMaNV());
                employee.setAccount(acc);
                result.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public List<Employee> searchNhanVienByName(String keyword) throws Exception {
        List<Employee> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM  NHANVIEN NV, TAIKHOAN TK WHERE NV.MA_NV = TK.MA_NV AND CONCAT(NV.HO,' ',NV.TEN) LIKE '%" + keyword + "%'";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setMaNV(resultset.getString(1));
                employee.setFirstName(resultset.getString(2));
                employee.setLastName(resultset.getString(3));
                employee.setSdt(resultset.getString(4));
                employee.setRole(Integer.parseInt(resultset.getString(5)));
                employee.setGioiTinh(resultset.getString(6));
                TaiKhoan acc = new TaiKhoan();
                acc.setId(resultset.getInt(7));
                acc.setAccount(resultset.getString(8));
                acc.setPassword(resultset.getString(9));
                acc.setTrangThai(resultset.getBoolean(10));
                acc.setManv(employee.getMaNV());
                employee.setAccount(acc);
                result.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
