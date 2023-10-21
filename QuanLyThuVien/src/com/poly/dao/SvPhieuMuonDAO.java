/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.ChiTietPhieuMuon;
import com.poly.model.PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SvPhieuMuonDAO {
    public List<PhieuMuon> selectAllPm(String maSv, int trangThai) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
               
                if (trangThai == -1) {
                     String sql = "SELECT MaPhieuMuon, MaSinhVien, MaNhanVien, NgayMuon, NgayTra, GhiChu, TrangThai FROM dbo.PhieuMuon WHERE MaSinhVien = ?";
                    rs = Xjdbc.query(sql,maSv);
                }else{
                     String sql = "SELECT MaPhieuMuon, MaSinhVien, MaNhanVien, NgayMuon, NgayTra, GhiChu, TrangThai FROM dbo.PhieuMuon WHERE MaSinhVien = ? AND TrangThai = ?";
                     rs = Xjdbc.query(sql,maSv,trangThai);
                }
                
                while(rs.next()){
                    PhieuMuon pm = new PhieuMuon(
                            rs.getString("MaPhieuMuon"),
                            rs.getString("MaSinhVien"),
                            rs.getString("MaNhanVien"),
                            rs.getString("NgayMuon"),
                            rs.getString("NgayTra"),
                            rs.getString("GhiChu"),
                            rs.getBoolean("TrangThai")
                    );
                    list.add(pm);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<ChiTietPhieuMuon> selectAllPmCt(String pm) {
        List<ChiTietPhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT MaPhieuMuon, MaSach, SoLuong FROM dbo.ChiTietPhieuMuon WHERE MaPhieuMuon = ?";
                rs = Xjdbc.query(sql,pm);
                while(rs.next()){
                    ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon(
                            rs.getString("MaPhieuMuon"),
                            rs.getString("MaSach"),
                            rs.getInt("SoLuong")
                    );
                    list.add(ctpm);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
