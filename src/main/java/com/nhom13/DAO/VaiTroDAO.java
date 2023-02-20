/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.VaiTro;
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
public class VaiTroDAO {
    public List<VaiTro> findAll(){
        List<VaiTro> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try{
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM VAITRO";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                VaiTro vaiTro = new VaiTro();
                vaiTro.setId(resultSet.getInt(1));
                vaiTro.setName(resultSet.getString(2));
                result.add(vaiTro);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public void save(VaiTro vaiTro){
        
    }
    public void update(VaiTro vaiTro){
        
    }
    public VaiTro findById(int id){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        VaiTro vaiTro = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql= "SELECT * FROM VAITRO WHERE ID_VAI_TRO = " + id ;
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                vaiTro = new VaiTro();
                vaiTro.setId(resultSet.getInt(1));
                vaiTro.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vaiTro;

        
       
    }
    public void delete(VaiTro vaiTro){
        Connection con = null;
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM VAITRO WHERE ID_VAI_TRO = " + vaiTro.getId();
            statement = con.prepareCall(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
