/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import database.JDBChelper;
import entity.DonHangChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public class DonHangChiTietDAO implements EntityDAO<DonHangChiTiet> {

    final String insert_SQL = "insert into donHangChiTiet (maDonHang, maMonAn, soLuongMon) values(?,?,?)";
    final String update_SQL = "update donHangChiTiet set maDonHang = ?, maMonAn = ?,soLuongMon = ? where maDonHangChiTiet = ?";
    final String delete_SQL = "delete from donHangChiTiet where maDonHangChiTiet = ?";
    final String selectALL_SQL = "select * from donHangChiTiet";
    final String selectByID_SQL = "select * from donHangChiTiet where maDonHangChiTiet = ?";

    @Override
    public void insert(DonHangChiTiet E) {
        JDBChelper.Update(insert_SQL, E.getMaDonChiTiet(),E.getMaDonHang(),E.getMaMonAn(),E.getSoLuong());
    }

    @Override
    public void update(DonHangChiTiet E) {
        JDBChelper.Update(update_SQL, E.getMaDonHang(),E.getMaMonAn(),E.getSoLuong(),E.getMaDonChiTiet());
    }

    @Override
    public int delete(String ID) {
         return JDBChelper.Update(delete_SQL, ID);
    }

    @Override
    public List<DonHangChiTiet> selectAll() {
        return selectBySQL(selectALL_SQL);
    }

    @Override
    public DonHangChiTiet findById(String ID) {
        List<DonHangChiTiet> list = selectBySQL(selectByID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DonHangChiTiet> selectBySQL(String sql, Object... args) {
        List<DonHangChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql, args);
            while (rs.next()) {
                DonHangChiTiet entity = new DonHangChiTiet();
                    entity.setMaDonChiTiet(rs.getInt("maDonHangChiTiet"));
                    entity.setMaDonHang(rs.getInt("maDonHang"));
                    entity.setMaMonAn(rs.getString("maMonAn"));
                    entity.setSoLuong(rs.getInt("soLuongMon"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return list;
    }

}
