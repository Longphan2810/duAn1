/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import database.JDBChelper;
import entity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public class HoaDonDAO implements EntityDAO<HoaDon> {

    final String insert_SQL = "insert into hoaDon (maDonHang, ngayTao, trangThai, maNhanVien) values(?,?,?,?)";
    final String update_SQL = "update hoaDon set maDonHang = ?, ngayTao = ?,trangThai = ?, maNhanVien = ? where maHoaDon = ?";
    final String delete_SQL = "delete from hoaDon where maHoaDon = ?";
    final String selectALL_SQL = "select * from hoaDon";
    final String selectByID_SQL = "select * from hoaDon where maHoaDon = ?";

    @Override
    public void insert(HoaDon E) {
        JDBChelper.Update(insert_SQL, E.getMaDonHang(),E.getNgayTao(),E.getTrangThai(),E.getMaNhanVien());
    }

    @Override
    public void update(HoaDon E) {
        JDBChelper.Update(update_SQL, E.getMaDonHang(),E.getNgayTao(),E.getTrangThai(),E.getMaNhanVien(),E.getMaHoaDon());
    }

    @Override
    public int delete(String ID) {
        return JDBChelper.Update(delete_SQL, ID);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySQL(selectALL_SQL);
    }

    @Override
    public HoaDon findById(String ID) {
         List<HoaDon> list = selectBySQL(selectByID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                    entity.setMaHoaDon(rs.getInt("maHoaDon"));
                    entity.setMaDonHang(rs.getInt("maDonHang"));
                    entity.setNgayTao(rs.getDate("ngayTao"));
                    entity.setTrangThai(rs.getString("trangThai"));
                    entity.setMaNhanVien(rs.getString("maNhanVien"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return list;
    }
    public List<Integer> selectDays() {
        String sql = "Select distinct Day(ngayTao) as Days from donHang where trangThai like 'Da thanh toan' order by  Days desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql);
            while (rs.next()) {
                int Days = rs.getInt("Days");
                list.add(Days);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
