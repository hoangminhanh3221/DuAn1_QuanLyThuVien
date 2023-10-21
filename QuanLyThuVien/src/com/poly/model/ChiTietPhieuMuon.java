/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;

/**
 *
 * @author hma20
 */
public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String maSach;
    private int soLuong;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(String maPhieuMuon, String maSach, int soLuong) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    
}
