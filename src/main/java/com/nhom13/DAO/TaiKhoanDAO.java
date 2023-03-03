
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TaiKhoanDAO {
    
    public TaiKhoan findAccount(String account, String password) throws Exception {
        String sql = "SELECT * FROM TAIKHOAN WHERE ACCOUNT = ? AND PASSWORD = ?";
        
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement emp = con.prepareStatement(sql);) {

            emp.setString(1, account);
            emp.setString(2, password);
            ResultSet result = emp.executeQuery();

            while (result.next()) {
                TaiKhoan temp = new TaiKhoan();
                temp.setId(result.getInt(1));
                temp.setAccount(result.getString(2));
                temp.setPassword(result.getString(3));
                temp.setTrangThai(result.getBoolean(4));
                temp.setManv(result.getString(5));
                return temp;
            }
            return null;
        }
    }

    public List<TaiKhoan> findAll() throws Exception {
        String sql = "SELECT * FROM TAIKHOAN";
        List<TaiKhoan> rs = new ArrayList<>();
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement emp = con.prepareStatement(sql);) {

            ResultSet result = emp.executeQuery();

            while (result.next()) {
                TaiKhoan temp = new TaiKhoan();
                temp.setId(result.getInt(1));
                temp.setAccount(result.getString(2));
                temp.setPassword(result.getString(3));
                temp.setTrangThai(result.getBoolean(4));
                temp.setManv(result.getString(5));
                rs.add(temp);
            }
            return rs;
        }
    }
    
    public void save(TaiKhoan account)throws Exception{
        String sql = "INSERT INTO TAIKHOAN(ACCOUNT, PASSWORD, TRANG_THAI, MA_NV) VALUES(?,?,?,?)";
        
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement tk = con.prepareStatement(sql);) {

            tk.setString(1,account.getAccount() );
            tk.setString(2, account.getPassword());
            tk.setBoolean(3, account.isTrangThai());
            tk.setString(4,account.getManv());
            
            tk.executeUpdate();
            
        }
    }
    
    
       public void update(TaiKhoan account) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String sql = "UPDATE TAIKHOAN SET PASSWORD = ? WHERE ACCOUNT = ?";
            statement = con.prepareCall(sql);
            statement.setString(1, account.getPassword());
            statement.setString(2, account.getAccount());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
