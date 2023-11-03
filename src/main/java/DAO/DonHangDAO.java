/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.JDBChelper;
import entity.DonHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public class DonHangDAO implements EntityDAO<DonHang> {

    final String insert_SQL = "insert into donHang (ngayTao, maNhanVien, trangThai) values(?,?,?)";
    final String update_SQL = "update donHang set ngayTao = ?, maNhanVien = ?,trangThai = ? where maDonHang = ?";
    final String delete_SQL = "delete from donHang where maDonHang = ?";
    final String selectALL_SQL = "select * from donHang";
    final String selectByID_SQL = "select * from donHang where maDonHang = ?";

    @Override
    public void insert(DonHang E) {
         JDBChelper.Update(insert_SQL, E.getMaDonHang(),E.getNgayTao(),E.getMaNhanVien(),E.getTrangThai());
    }

    @Override
    public void update(DonHang E) {
      JDBChelper.Update(update_SQL, E.getNgayTao(),E.getMaNhanVien(),E.getTrangThai(),E.getMaDonHang());
    }

    @Override
    public int delete(String ID) {
         return JDBChelper.Update(delete_SQL, ID);
    }

    @Override
    public List<DonHang> selectAll() {
       return selectBySQL(selectALL_SQL);
    }

    @Override
    public DonHang findById(String ID) {
        List<DonHang> list = selectBySQL(selectByID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DonHang> selectBySQL(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql, args);
            while (rs.next()) {
                DonHang entity = new DonHang();
                    entity.setMaDonHang(rs.getInt("maDonHang"));
                    entity.setNgayTao(rs.getDate("ngayTao"));
                    entity.setMaNhanVien(rs.getString("maNhanVien"));
                    entity.setTrangThai(rs.getString("trangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return list;
    }
}
