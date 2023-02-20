package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Employee;
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

//    public String checkRole(String id){
//        switch(id){
//            case "1": return "Nhân viên";
//            case "2": return "Quản lí";
//            default : return "";
//        }
//    }
    public Employee findEmployeeByAccount(String account, String password) throws Exception {
        String sql = "SELECT * FROM NHANVIEN WHERE ACCOUNT = ? AND PASSWORD = ?";

        try ( Connection con = DatabaseHelper.openConnection();  PreparedStatement emp = con.prepareStatement(sql);) {

            emp.setString(1, account);
            emp.setString(2, password);
            ResultSet result = emp.executeQuery();

            while (result.next()) {
                Employee temp = new Employee();
                temp.setMaNV(result.getString(1));
                temp.setFirstName(result.getString(2));
                temp.setLastName(result.getString(3));
                temp.setAccount(result.getString(4));
                temp.setPassword(result.getString(5));
                temp.setSdt(result.getString(6));
                temp.setRole(result.getInt(7));
                temp.setStatus(result.getBoolean(8));

                return temp;
            }
            return null;
        }
    }

    public void saveEmployee(Employee employee) throws Exception {
        Connection con = null ;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String account = employee.getAccount();
            String password = employee.getPassword();
            String sdt = employee.getSdt();
            int idRole = employee.getRole();
            boolean status = employee.isStatus();
            String sql = "INSERT INTO NHANVIEN(MA_NV , HO , TEN, ACCOUNT,PASSWORD ,SDT ,ID_VAI_TRO,TRANG_THAI) "
                    + "VALUES(? , ? , ? ,?,?,?,?,? )";
            statement = con.prepareCall(sql);
            statement.setString(1, maNV);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, account);
            statement.setString(5, password);
            statement.setString(6, sdt);
            statement.setInt(7, idRole);
            statement.setBoolean(8, status);
            statement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) throws Exception {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String account = employee.getAccount();
            String password = employee.getPassword();
            String sdt = employee.getSdt();
            int idRole = employee.getRole();
            boolean status = employee.isStatus();
            String sql = "UPDATE NHANVIEN SET MA_NV = ? , HO = ? , TEN = ? , ACCOUNT = ? , PASSWORD = ? ,"
                    + "SDT = ? , ID_VAITRO = ? , TRANG_THAI = ?";
            statement = con.prepareCall(sql);
            statement.setString(1, maNV);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, account);
            statement.setString(5, password);
            statement.setString(6, sdt);
            statement.setInt(7, idRole);
            statement.setBoolean(8, status);
            statement.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) throws Exception {
         Connection con = null ;
         PreparedStatement statement = null;
        try  {
           con = DatabaseHelper.openConnection();
            
            String sql = "DELETE FROM NHANVIEN WHERE MA_NV = ?1";
            statement = con.prepareCall(sql);
            statement.setString(1, employee.getMaNV());
            statement.executeUpdate();

        }catch (Exception ex){
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
            String sql = "select * from NHANVIEN";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setMaNV(resultset.getString(1));
                employee.setFirstName(resultset.getString(2));
                employee.setLastName(resultset.getString(3));
                employee.setAccount(resultset.getString(4));
                employee.setPassword(resultset.getString(5));
                employee.setSdt(resultset.getString(6));
                employee.setRole(Integer.parseInt(resultset.getString(7)));
                employee.setStatus(resultset.getBoolean(8));
                result.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
