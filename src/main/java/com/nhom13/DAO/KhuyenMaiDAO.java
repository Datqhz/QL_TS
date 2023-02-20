/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
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
public class KhuyenMaiDAO {
  
    public List<KhuyenMai> findAll(){
        List<KhuyenMai> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try{
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI ";
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(resultset.getInt(1));
                khuyenMai.setNgayApDung(resultset.getDate(2));
                khuyenMai.setNgayKetThuc(resultset.getDate(3));
                khuyenMai.setGiaTri(resultset.getInt(4));
                khuyenMai.setLyDo(resultset.getString(5));
                khuyenMai.setMaNv(resultset.getString(6));
                result.add(khuyenMai);
                
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
    public KhuyenMai findById(int id){
        Connection con = null ;
        PreparedStatement statement = null;
        KhuyenMai khuyenMai =  new KhuyenMai();
        try{
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM KHUYENMAI WHERE ID_KM = " + id ;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                khuyenMai = new KhuyenMai();
                khuyenMai.setId(resultset.getInt(1));
                khuyenMai.setNgayApDung(resultset.getDate(2));
                khuyenMai.setNgayKetThuc(resultset.getDate(3));
                khuyenMai.setGiaTri(resultset.getInt(4));
                khuyenMai.setLyDo(resultset.getString(5));
                khuyenMai.setMaNv(resultset.getString(6));
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return khuyenMai;
    }
    public void deleteBan(KhuyenMai khuyenMai){
        PreparedStatement state = null; 
        Connection con = null;
        try{
            con = DatabaseHelper.openConnection();
            int id = khuyenMai.getId();
            String sql = "DELETE FROM KHUYENMAI WHERE id = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
