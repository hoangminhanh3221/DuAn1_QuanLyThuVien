/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;
/**
 *
 * @author hma20
 */
public class Sach {
    private String maSach;
    private String maTheLoai;
    private String maTacGia;
    private String maNhaXuatBan;
    private String tenSach;
    private int soLuong;
    private String ngayNhap;
    private String hinhAnh;
    private String link;

    public Sach() {
    }

    public Sach(String maSach, String maTheLoai, String maTacGia, String maNhaXuatBan, String tenSach, int soLuong, String ngayNhap, String hinhAnh, String link) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.maTacGia = maTacGia;
        this.maNhaXuatBan = maNhaXuatBan;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.hinhAnh = hinhAnh;
        this.link = link;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNhaXuatBan() {
        return maNhaXuatBan;
    }

    public void setMaNhaXuatBan(String maNhaXuatBan) {
        this.maNhaXuatBan = maNhaXuatBan;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
    
}
