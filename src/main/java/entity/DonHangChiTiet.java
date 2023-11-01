/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thinkpad E440
 */
public class DonHangChiTiet {
    private int  maDonChiTiet;
    private int maDonHang;
    private String maMonAn;
    private int soLuong;

    public DonHangChiTiet(int maDonChiTiet, int maDonHang, String maMonAn, int soLuong) {
        this.maDonChiTiet = maDonChiTiet;
        this.maDonHang = maDonHang;
        this.maMonAn = maMonAn;
        this.soLuong = soLuong;
    }

    public DonHangChiTiet() {
    }

    public int getMaDonChiTiet() {
        return maDonChiTiet;
    }

    public void setMaDonChiTiet(int maDonChiTiet) {
        this.maDonChiTiet = maDonChiTiet;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
