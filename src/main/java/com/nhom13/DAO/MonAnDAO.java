/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.MonAn;
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
public class MonAnDAO {
    public List<MonAn> findAll(){
        List<MonAn> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try{
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM MONAN ";
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setIdLoaiMon(resultset.getInt(7));
                monAn.setMaNv(resultset.getString(8));
                result.add(monAn);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public void save(MonAn monAn){
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String ten = monAn.getTenMon();
            String donVi = monAn.getDonVi();
            int gia = monAn.getGia();
            String anh = monAn.getAnh();
            String moTa = monAn.getMoTa();
            int idLoaiMon = monAn.getIdLoaiMon();
            String maNv = monAn.getMaNv();
            String sql = "INSERT INTO MONAN(ID_MON , TEN_MON , DON_VI , GIA , ANH , MO_TA , ID_LOAI_MON , MA_NV)"
                    + "           VALUES(? , ? , ? , ? , ? , ? , ? , ? ) ";
            statement = con.prepareCall(sql);
            statement.setInt(id, id);
            statement.setString(2, ten);
            statement.setString(3, donVi);
            statement.setInt(4, gia);
            statement.setString(5, anh);
            statement.setString(6, moTa);
            statement.setInt(7, idLoaiMon);
            statement.setString(8, maNv);
            statement.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    public void update(){
        
    }
    public MonAn findById(int id){
        Connection con = null ;
        PreparedStatement statement = null;
        MonAn monAn = null;
        try{
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM MONAN WHERE ID_MON = " + id ;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setMaNv(resultset.getString(7));
                monAn.setIdLoaiMon(resultset.getInt(8));
                
                
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return monAn;
    }
    public void deleteBan(MonAn monAn){
        PreparedStatement state = null; 
        Connection con = null;
        try{
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String sql = "DELETE FROM MONAN WHERE ID_MON = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
