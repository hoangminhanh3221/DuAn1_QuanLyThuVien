/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;


/**
 *
 * @author hma20
 */
public class PhieuMuon {
    private String maPhieuMuon;
    private String maSinhVien;
    private String maNhanVien;
    private String ngayMuon;
    private String ngayTra;
    private String ghiChu;
    private boolean trangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieuMuon, String maSinhVien, String maNhanVien, String ngayMuon, String ngayTra, String ghiChu, boolean trangThai) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSinhVien = maSinhVien;
        this.maNhanVien = maNhanVien;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
