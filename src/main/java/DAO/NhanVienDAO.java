/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import database.JDBChelper;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad E440
 */
public class NhanVienDAO implements EntityDAO<NhanVien> {

    final String insert_SQL = "insert into nhanVien (maNhanVien, matKhau, tenNhanVien, role, ngaySinh, soDienThoai) values(?,?,?,?,?,?)";
    final String update_SQL = "update nhanVien set matKhau = ?,tenNhanVien = ?, role = ?,ngaySinh = ?,soDienThoai = ? where maNhanVien = ?";
    final String delete_SQL = "delete from nhanVien where maNhanVien = ?";
    final String selectALL_SQL = "select * from nhanVien";
    final String selectByID_SQL = "select * from nhanVien where maNhanVien = ?";

    @Override
    public void insert(NhanVien E) {
         JDBChelper.Update(insert_SQL, E.getMaNhanVien(),E.getTenNhanVien(),E.getMatKhau(),E.getNgaySinh(),E.getSoDienThoai());
    }

    @Override
    public void update(NhanVien E) {
       JDBChelper.Update(update_SQL, E.getTenNhanVien(),E.getMatKhau(),E.getNgaySinh(),E.getSoDienThoai(),E.getMaNhanVien());
    }

    @Override
    public int delete(String ID) {
         return JDBChelper.Update(delete_SQL, ID);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySQL(selectALL_SQL);
    }

    @Override
    public NhanVien findById(String ID) {
         List<NhanVien> list = selectBySQL(selectByID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.Query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                    entity.setMaNhanVien(rs.getString("maNhanVien"));
                    entity.setMatKhau(rs.getString("matKhau"));
                    entity.setTenNhanVien(rs.getString("tenNhanVien"));
                    entity.setRole(rs.getBoolean("role"));
                    entity.setNgaySinh(rs.getDate("ngaySinh"));              
                    entity.setSoDienThoai(rs.getString("soDienThoai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return list;
    }

}
