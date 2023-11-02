/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Thinkpad E440
 */
public class HoaDon {
    private int maHoaDon;
    private int maDonHang;
    private Date ngayTao;
    private String trangThai;
    private String maNhanVien;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int maDonHang, Date ngayTao, String trangThai, String maNhanVien) {
        this.maHoaDon = maHoaDon;
        this.maDonHang = maDonHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
    }

  

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
