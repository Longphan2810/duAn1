/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thinkpad E440
 */
public class FoodAndDrink {

    private String maThucAn;
    private String tenThucAn;
    private float gia;
    private String hinhAnh;
    private boolean trangThai;
    private String maNhanVien;

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public FoodAndDrink(String maThucAn, String tenThucAn, float gia, String hinhAnh, boolean trangThai, String maNhanVien) {
        this.maThucAn = maThucAn;
        this.tenThucAn = tenThucAn;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

  

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public FoodAndDrink(String maThucAn, String tenThucAn, float gia, String hinhAnh, boolean trangThai) {
        this.maThucAn = maThucAn;
        this.tenThucAn = tenThucAn;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public FoodAndDrink(String maThucAn, String tenThucAn) {
        this.maThucAn = maThucAn;
        this.tenThucAn = tenThucAn;
    }

    public String getMaThucAn() {
        return maThucAn;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setMaThucAn(String maThucAn) {
        this.maThucAn = maThucAn;
    }

    public String getTenThucAn() {
        return tenThucAn;
    }

    public void setTenThucAn(String tenThucAn) {
        this.tenThucAn = tenThucAn;
    }

    @Override
    public String toString() {
        return tenThucAn;
    }

}
