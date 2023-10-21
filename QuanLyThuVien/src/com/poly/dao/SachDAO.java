/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.XDate;
import com.poly.helper.Xjdbc;
import com.poly.model.NhaXuatBan;
import com.poly.model.Sach;
import com.poly.model.TacGia;
import com.poly.model.TheLoaiSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MINH HIEU
 */
public class SachDAO extends QuanLyThuVien<Sach, String> {

    String INSERT_SQL = "insert into Sach(MaSach, MaTheLoai, MaTacGia, MaNhaXuatBan, TenSach, SoLuong, NgayNhap, Hinh, Link) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "update Sach set MaTheLoai=?, MaTacGia=?, MaNhaXuatBan=?, TenSach=?, SoLuong=?, NgayNhap=?, Hinh=?, Link=? where MaSach = ?";
    String DELETE_SQL = "delete from Sach where MaSach = ?";
    String SELECT_ALL_SQL = "select * from Sach";
    String SELECT_BY_ID_SQL = "select * from Sach where MaSach = ?";

    @Override
    public void insert(Sach entity) {
        java.sql.Date ngayNhap = new java.sql.Date(XDate.toDate(entity.getNgayNhap(), "dd/MM/yyyy").getTime());
        try {
            Xjdbc.update(
                    INSERT_SQL,
                    entity.getMaSach(),
                    entity.getMaTheLoai(),
                    entity.getMaTacGia(),
                    entity.getMaNhaXuatBan(),
                    entity.getTenSach(),
                    entity.getSoLuong(),
                    ngayNhap,
                    entity.getHinhAnh(),
                    entity.getLink()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Sach entity) {
        java.sql.Date ngayNhap = new java.sql.Date(XDate.toDate(entity.getNgayNhap(), "dd/MM/yyyy").getTime());
        try {
            Xjdbc.update(
                    UPDATE_SQL,
                    entity.getMaTheLoai(),
                    entity.getMaTacGia(),
                    entity.getMaNhaXuatBan(),
                    entity.getTenSach(),
                    entity.getSoLuong(),
                    ngayNhap,
                    entity.getHinhAnh(),
                    entity.getLink(),
                    entity.getMaSach()
            );
            System.out.println("2");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Xjdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    Sach entity = new Sach(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            XDate.toString(rs.getDate(7), "dd/MM/yyyy"),
                            rs.getString(8),
                            rs.getString(9)
                    );
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<TheLoaiSach> getMaTheLoai() {
        List<TheLoaiSach> list = new ArrayList<>();
        try {
            String sql = "select * from TheLoaiSach";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                TheLoaiSach tls = new TheLoaiSach(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                list.add(tls);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TacGia> getMaTacGia() {
        List<TacGia> list = new ArrayList<>();
        try {
            String sql = "select MaTacGia, TenTacGia from TacGia";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                TacGia tg = new TacGia(
                        rs.getString(1),
                        rs.getString(2)
                );
                list.add(tg);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhaXuatBan> getMaNXB() {
        List<NhaXuatBan> list = new ArrayList<>();
        try {
            String sql = "select * from NhaXuatBan";
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan(
                        rs.getString(1),
                        rs.getString(2)
                );
                list.add(nxb);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkMaSach(String maS) {
        boolean isCheck = false;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_CheckMaSach (?)}";
                rs = Xjdbc.query(sql, maS);
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
