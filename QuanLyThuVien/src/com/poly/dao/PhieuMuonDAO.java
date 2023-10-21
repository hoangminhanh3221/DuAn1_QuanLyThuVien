/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.XDate;
import com.poly.helper.Xjdbc;
import com.poly.model.ChiTietPhieuMuon;
import com.poly.model.PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hma20
 */
public class PhieuMuonDAO extends QuanLyThuVien<PhieuMuon, String>{

    String INSERT_PM_SQL = "INSERT INTO PhieuMuon (MaPhieuMuon, MaSinhVien, MaNhanVien, NgayMuon, NgayTra, GhiChu) VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_PM_SQL = "UPDATE PhieuMuon SET MaSinhVien=?, MaNhanVien=?, NgayMuon=?, NgayTra=?, GhiChu=? where MaPhieuMuon = ?";
    String INSERT_CTPM_SQL = "INSERT INTO ChiTietPhieuMuon (MaPhieuMuon, MaSach, SoLuong) VALUES (?, ?, ?)";
    String DELETE_PM_SQL = "DELETE FROM PhieuMuon WHERE MaPhieuMuon = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuMuon WHERE MaPhieuMuon = ?";
    String SELECT_CTPM = "SELECT * FROM ChiTietPhieuMuon WHERE MaPhieuMuon = ?";
    String SELECT_ALL_SQL = "SELECT * FROM PhieuMuon";
    
    @Override
    public void insert(PhieuMuon entity) {
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
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PhieuMuon entity) {
        java.sql.Date ngayMuon = new java.sql.Date(XDate.toDate(entity.getNgayMuon(), "dd/MM/yyyy").getTime());
        java.sql.Date ngayTra = new java.sql.Date(XDate.toDate(entity.getNgayTra(), "dd/MM/yyyy").getTime());

        try {
            Xjdbc.update(
                    UPDATE_PM_SQL,
                    entity.getMaSinhVien(),
                    entity.getMaNhanVien(),
                    ngayMuon,
                    ngayTra,
                    entity.getGhiChu(),
                    entity.getMaPhieuMuon()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Xjdbc.update(DELETE_PM_SQL,id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }

    @Override
    public PhieuMuon selectById(String id) {
        List<PhieuMuon> list = (List<PhieuMuon>) this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return (List<PhieuMuon>) this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        XDate.toString(rs.getDate(4), "dd/MM/yyyy"),
                        XDate.toString(rs.getDate(5), "dd/MM/yyyy"),
                        rs.getString(6),
                        rs.getBoolean(7)
                );
                list.add(pm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public List<ChiTietPhieuMuon> selectCTPM(String maPM) {
        List<ChiTietPhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(SELECT_CTPM, maPM);
            while (rs.next()) {
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                list.add(ctpm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
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
}
