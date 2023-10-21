/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;
/**
 *
 * @author hma20
 */
public class TacGia {
    private String maTacGia;
    private String tenTacGia;
    private boolean gioiTinh;
    private String ngaySinh;

    public TacGia() {
    }

    public TacGia(String maTacGia, String tenTacGia, boolean gioiTinh, String ngaySinh) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public TacGia(String maTacGia, String tenTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
    }
    
    

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
}
