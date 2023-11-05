/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.JDBChelper;
import entity.FoodAndDrink;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public class FoodDAO implements EntityDAO<FoodAndDrink> {

    final String insert_SQL = "insert into monAn (maMonAn, tenMonAn, giaTien, hinhAnh, maNhanVien, trangThai) values(?,?,?,?,?,?)";
    final String update_SQL = "update monAn set tenMonAn = ?,giaTien = ?, hinhAnh = ?,maNhanVien = ?,trangThai = ? where maMonAn = ?";
    final String delete_SQL = "delete from monAn where maMonAn = ?";
    final String selectALL_SQL = "select * from monAn";
    final String selectByID_SQL = "select * from monAn where maMonAn = ?";

    @Override
    public void insert(FoodAndDrink E) {
        JDBChelper.Update(insert_SQL, E.getMaThucAn(), E.getTenThucAn(), E.getGia(), E.getHinhAnh(), E.getMaNhanVien(), E.isTrangThai());
    }

    @Override
    public void update(FoodAndDrink E) {
        JDBChelper.Update(update_SQL, E.getTenThucAn(), E.getGia(), E.getHinhAnh(),E.getMaNhanVien(), E.isTrangThai(), E.getMaThucAn());
    }

    @Override
    public int delete(String ID) {
        return JDBChelper.Update(delete_SQL, ID);

    }

    @Override
    public List<FoodAndDrink> selectAll() {
        return selectBySQL(selectALL_SQL);
    }

    @Override
    public FoodAndDrink findById(String ID) {
        List<FoodAndDrink> list = selectBySQL(selectByID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<FoodAndDrink> selectBySQL(String sql, Object... args) {
        List<FoodAndDrink> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql, args);
            while (rs.next()) {
                FoodAndDrink entity = new FoodAndDrink();
                entity.setMaThucAn(rs.getString("maMonAn"));
                entity.setTenThucAn(rs.getString("tenMonAn"));
                entity.setGia(rs.getFloat("giaTien"));
                entity.setHinhAnh(rs.getString("hinhAnh"));
                entity.setMaNhanVien(rs.getString("maNhanVien"));
                entity.setTrangThai(rs.getBoolean("trangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return list;
    }
}
