/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class HoaDonDao {
    
    public List<HoaDon> findAll(){
        List<HoaDon> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM HOADON";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(resultSet.getInt(1));
                hoaDon.setHinhThucThanhToan(resultSet.getString(2));
                hoaDon.setNgayLap(resultSet.getDate(3));
                hoaDon.setThanhTien(resultSet.getInt(4));
                hoaDon.setTenBan(resultSet.getString(5));
                hoaDon.setIdNhanVien(resultSet.getString(6));
                hoaDon.setIdKhuyenMai(resultSet.getInt(7));
                hoaDon.setIdKhachHang(resultSet.getInt(8));
                result.add(hoaDon);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
     public void save(HoaDon hoaDon){
        Connection con = null ;
        PreparedStatement statement = null;
         try {
             con = DatabaseHelper.openConnection();
             // list ra atribute 
             int id = hoaDon.getId();
             String type = hoaDon.getHinhThucThanhToan();
             Date ngayLap = hoaDon.getNgayLap();
             int sum = hoaDon.getThanhTien();
             String tenBan = hoaDon.getTenBan();
             String maNv = hoaDon.getIdNhanVien();
             int idKhuyenMai = hoaDon.getIdKhuyenMai();
             int idKhachHang = hoaDon.getIdKhachHang();

             // query 
             String sql = "INSERT INTO HOADON(SO_HOA_DON , HINH_THUC_TT , NGAY_LAP , THANH_TIEN , "
                     + "TEN_BAN , MA_NV , ID_KHUYEN_MAI, ID_KHACH_HANG) VALUES (? , ? , ? ,?,? ,?,?,?)";
             // statement.prepareCall...
             statement = con.prepareCall(sql);
             // set atributes for statement
             statement.setInt(1, id);
             statement.setString(2, type);
             statement.setDate(3, ngayLap);
             statement.setInt(4, sum);
             statement.setString(5, sql);
             statement.setString(6 , maNv);
             statement.setInt(7, idKhuyenMai);
             statement.setInt(8,idKhuyenMai);
             // statement.executeQuery
             statement.executeUpdate();
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         
    }
     public void upate(HoaDon hoaDon){
         
         
     }
     
     public void delete(HoaDon hoaDon){
          Connection con = null ;
        PreparedStatement statement = null;
         try {
             con = DatabaseHelper.openConnection();
             String sql = "DELETE FROM HOADON WHERE SO_HOA_DON = " + hoaDon.getId();
             statement = con.prepareCall(sql);
             statement.executeUpdate();
                   
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
   
}
