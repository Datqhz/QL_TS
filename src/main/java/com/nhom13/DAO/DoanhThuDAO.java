package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.DoanhThuTheoMonAn;
import com.nhom13.Entity.DoanhThuTheoNhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DoanhThuDAO {

    public int TongDoanhThuTheoMonAn(int idMonAn) {
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT M.TEN_MON_AN ,  SUM(C.GIA) AS REVENUE "
                    + "FROM CTHOADON C "
                    + "JOIN MONAN M ON C.ID_MON = M.ID_MON "
                    + "GROUP BY A.ID_MON "
                    + "ORDER BY REVENUE DESC "
                    + "HAVING A.ID_MON = " + idMonAn;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int TongDoanhThuTheoNhanVien() {
        int sum = 0;
        Connection con = null;

        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = """
                     SELECT SUM(A.GIA) AS REVENUE 
                     FROM  HOADON H
                     JOIN CTHOADON A ON A.SO_HOA_DON = H.SO_HOA_DON
                     JOIN NHANVIEN N ON N.MA_NV = H.MA_NV
                     GROUP BY H.MA_NV """;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public List<DoanhThuTheoNhanVien> TongDoanhThuTheoNhanVienTuNgayDenNgay(String fromDate, String toDate) {

        List<DoanhThuTheoNhanVien> result = new ArrayList<>();
        Connection con = null;

        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
                                        String sql = "SELECT NV.MA_NV , CONCAT(NV.HO , ' ' , NV.TEN ) AS HO_VA_TEN ,count(H.SO_HOA_DON) So_hoa_don, SUM(H.THANH_TIEN) AS DOANH_THU  FROM HOADON H JOIN NHANVIEN NV USING(MA_NV)  WHERE H.NGAY_LAP >= \""+fromDate+"\" AND H.NGAY_LAP <= \""+toDate+"\"  group by NV.MA_NV ORDER BY DOANH_THU DESC";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DoanhThuTheoNhanVien re = new DoanhThuTheoNhanVien();
                re.setIdNhanVien(resultSet.getInt(1));
                re.setHoTen(resultSet.getString(2));
                re.setSoHoaDon(resultSet.getInt(3));
                re.setTongDoanhThu(resultSet.getLong(4));
                result.add(re);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    

    // 
    public int TongSoNhanVien() {
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT COUNT(*) FROM NHANVIEN";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;

    }

    public List<DoanhThuTheoMonAn> topDoanhThu5MonAnTheoThoiGian(String date) {
        

        List<DoanhThuTheoMonAn> doanhThu = new ArrayList<>();

        Connection con = null;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = """
                         SELECT C.ID_MON AS ID_MON,M.TEN_MON ,concat(MONTH(H.NGAY_LAP) , '-' , YEAR(H.NGAY_LAP)) AS MONTH_YEAR, SUM(C.GIA) AS TONG_TIEN
                         FROM CTHOADON C
                         JOIN HOADON H USING(SO_HOA_DON) 
                         JOIN MONAN M USING(ID_MON)
                         GROUP BY C.ID_MON ,MONTH_YEAR
                         HAVING MONTH_YEAR = '"""+ date +"'\n"
                    + "ORDER BY TONG_TIEN DESC \n"
                    + "LIMIT 5";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DoanhThuTheoMonAn revenue = new DoanhThuTheoMonAn();
                revenue.setId(resultSet.getInt(1));
                revenue.setTenMon(resultSet.getString(2));
                revenue.setNgayLap(resultSet.getString(3));
                revenue.setTongTien(resultSet.getDouble(4));
                doanhThu.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;

    }
    
    public int soLuongHoaDon(String date){
        
        
        
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "select count(*) as tong from HOADON H WHERE concat(MONTH(H.NGAY_LAP) , '-' , YEAR(H.NGAY_LAP)) = '"+date+ "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    
    public int tongDoanhThuCuaNgay(String date ){
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "select sum(THANH_TIEN) from HOADON H WHERE concat(MONTH(H.NGAY_LAP) , '-' , YEAR(H.NGAY_LAP)) = '"+date+ "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    
    public int soLuongKhachHang(){
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT COUNT(*) FROM KHACHHANG";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    
    
    
    
}
