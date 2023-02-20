/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.LoaiMon;
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
public class BanDAO {
  
    public List<Ban> findAll(){
        List<Ban> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try{
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN ";
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                Ban ban = new Ban();
                ban.setId(resultset.getInt(1));
                ban.setTenBan(resultset.getString(2));
                ban.setNgayTao(resultset.getDate(3));
                ban.setTrangThai(resultset.getBoolean(4));
                result.add(ban);
                
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
    public Ban findById(int id){
        Connection con = null ;
        PreparedStatement statement = null;
        Ban ban =  new Ban();
        try{
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM BAN WHERE ID_BAN = " + id ;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                 ban = new Ban(resultset.getInt(1)
                 ,resultset.getString(2)
                 , resultset.getDate(3)
                 ,resultset.getBoolean(4));
                
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return ban;
    }
    public void deleteBan(Ban ban){
        PreparedStatement state = null; 
        Connection con = null;
        try{
            con = DatabaseHelper.openConnection();
            int id = ban.getId();
            String sql = "DELETE FROM BAN WHERE id = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
