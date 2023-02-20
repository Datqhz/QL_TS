
package com.nhom13.Database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseHelper {
    public static Connection openConnection()throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connect = "jdbc:sqlserver://localhost:1433;databaseName=BANTRASUA;user=sa;password=123456;encrypt=false";
        Connection  con = DriverManager.getConnection(connect);
       return con;
  }
    //    public static Connection openConnection2()throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String connect = "jdbc:sqlserver://localhost:3306;databaseName=CNPM;user=root;password=123456789;encrypt=false";
//        Connection  con = DriverManager.getConnection(connect);
//       return con;
//  }
}
