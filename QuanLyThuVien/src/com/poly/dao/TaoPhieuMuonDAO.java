/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.XDate;
import com.poly.model.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.poly.helper.Xjdbc;
import com.poly.model.SinhVien;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hma20
 */
public class TaoPhieuMuonDAO {

    String INSERT_PM_SQL = "INSERT INTO PhieuMuon (MaPhieuMuon, MaSinhVien, MaNhanVien, NgayMuon, NgayTra, GhiChu) VALUES (?, ?, ?, ?, ?, ?)";
    String INSERT_CTPM_SQL = "INSERT INTO ChiTietPhieuMuon (MaPhieuMuon, MaSach, SoLuong) VALUES (?, ?, ?)";

    public void insertPM(PhieuMuon entity) {
        java.sql.Date ngayMuon = new java.sql.Date(XDate.toDate(entity.getNgayMuon(), "dd/MM/yyyy").getTime());
        java.sql.Date ngayTra = new java.sql.Date(XDate.toDate(entity.getNgayTra(), "dd/MM/yyyy").getTime());

        try {
            Xjdbc.update(
                    INSERT_PM_SQL,
                    entity.getMaPhieuMuon(),
                    entity.getMaSinhVien(),
                    entity.getMaNhanVien(),
                    ngayMuon,
                    ngayTra,
                    entity.getGhiChu()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TaoPhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertCTPM(ChiTietPhieuMuon entity) {
        try {
            Xjdbc.update(
                    INSERT_CTPM_SQL,
                    entity.getMaPhieuMuon(),
                    entity.getMaSach(),
                    entity.getSoLuong()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TaoPhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Sach> getAllSach() {
        List<Sach> list = new ArrayList<>();
        try {
            String sql = "select * from Sach";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                Sach s = new Sach(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );
                list.add(s);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getMaSinhVien() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select MaSinhVien from SinhVien";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getMaNhanVien() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select MaNhanVien from NhanVien";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SinhVien getOneSinhVien(String maSV) {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "select * from SinhVien where MaSinhVien = ?";
            ResultSet rs = Xjdbc.query(sql, maSV);
            if (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );
                list.add(sv);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getTrangThaiMuonSachSV(String maSV) {
        String text = null;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TrangThaiMuonSachSV (?)}";
                rs = Xjdbc.query(sql, maSV);
                if (rs.next()) {
                    text = rs.getString(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return text;

    }

    public boolean checkMaPhieuMuon(String maPM) {
        boolean isCheck = false;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_CheckMaPhieuMuon (?)}";
                rs = Xjdbc.query(sql, maPM);
                if (rs.next()) {
                    isCheck = rs.getBoolean(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return isCheck;
    }

}
