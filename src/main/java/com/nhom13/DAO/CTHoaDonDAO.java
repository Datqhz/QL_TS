/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.ChiTietBan;
import com.nhom13.Entity.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class CTHoaDonDAO {
    public List<ChiTietHoaDon> findAll(){
        List<ChiTietHoaDon> result = new ArrayList<>();
        Connection con = null ;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM CTHOADON ";
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setId(resultSet.getInt(1));
                chiTietHoaDon.setIdHoaDon(resultSet.getInt(2));
                chiTietHoaDon.setIdMonAn(resultSet.getInt(3));
                chiTietHoaDon.setSoLuong(resultSet.getInt(4));
                chiTietHoaDon.setGia(resultSet.getInt(5));
                result.add(chiTietHoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return result;
    }
    public void save(ChiTietHoaDon chiTietHoaDon){
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = chiTietHoaDon.getId();
            int idHoaDon = chiTietHoaDon.getIdHoaDon();
            int idMonAn = chiTietHoaDon.getIdHoaDon();
            int quantity = chiTietHoaDon.getSoLuong();
            int gia = chiTietHoaDon.getGia();
            String sql = "INSERT INTO CTHOADON(ID_CT , ID_HOA_DON , ID_MON_AN , SO_LUONG , GIA) "
                    + "           VALUES( ? , ? , ? , ? , ?)";
            statement = con.prepareCall(sql);
            statement.setInt(1, id);
            statement.setInt(2, idHoaDon);
            statement.setInt(3, idMonAn);
            statement.setInt(4, quantity);
            statement.setInt(5, gia);
            
                  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void update(ChiTietHoaDon chiTietHoaDon){
        
    }
    public void delete(ChiTietHoaDon chiTietHoaDon){
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "DELETE FROM CTHOADON WHERE ID_CT = " + chiTietHoaDon.getId();
            statement = con.prepareCall(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
