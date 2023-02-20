/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.KhachHang;
import com.nhom13.Entity.KhuyenMai;
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
public class KhachHangDAO {
    public List<KhachHang> findAll(){
        List<KhachHang> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try{
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHACHHANG ";
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
               KhachHang khachHang = new KhachHang();
               khachHang.setId(resultset.getInt(1));
               khachHang.setHo(resultset.getString(2));
               khachHang.setTen(resultset.getString(3));
               khachHang.setNgaySinh(resultset.getDate(4));
               khachHang.setSdt(resultset.getString(5));
               result.add(khachHang);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public void save(){
        
    }
    public void update(){
        
    }
    public KhachHang findById(int id){
        Connection con = null ;
        PreparedStatement statement = null;
        KhachHang khachHang = null ;
        try{
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM KHACHHANG  WHERE ID_KH = " + id ;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                khachHang = new KhachHang();
                khachHang.setId(resultset.getInt(1));
                khachHang.setHo(resultset.getString(2));
                khachHang.setTen(resultset.getString(3));
                khachHang.setSdt(resultset.getString(4));
                khachHang.setNgaySinh(resultset.getDate(5));
                
                
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return khachHang;
    }
    public void deleteBan(KhachHang khachHang){
        PreparedStatement state = null; 
        Connection con = null;
        try{
            con = DatabaseHelper.openConnection();
            int id = khachHang.getId();
            String sql = "DELETE FROM KHACHHANG WHERE ID_KH = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
