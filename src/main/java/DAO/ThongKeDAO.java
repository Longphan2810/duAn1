/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.JDBChelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... agrs) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBChelper.Query(sql, agrs);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


public List<Object[]> getDoanhThu(Integer year, Integer month, Integer day) {
    String sql = "{Call sp_TKDoanhThu(?,?,?)}";
    String[] cols = {"DoanhThu", "MocThoiGian"};
    return getListOfArray(sql, cols, year, month, day);
}



public List<Object[]> getDoanhThuMonAn(Integer year, Integer month, Integer day) {
    String sql = "{Call sp_TKMonAn(?, ?,?)}";
    String[] cols = {"MocThoiGian", "MaMonAn", "TenMonAn", "DoanhThu", "DoanhThuPhanTram"};
    return getListOfArray(sql, cols, year, month, day);
}

}