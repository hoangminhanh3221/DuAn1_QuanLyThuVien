/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.PhieuMuon;
import com.poly.model.Sach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SvSachDAO {

    public Sach getFindSach(String maS) {
        Sach sach = null;

        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT MaSach, MaTheLoai, MaTacGia, MaNhaXuatBan, TenSach, SoLuong, NgayNhap, Hinh, Link FROM dbo.Sach WHERE MaSach = ?";
                rs = Xjdbc.query(sql, maS);
                while (rs.next()) {
                    sach = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return sach;
    }

    public List<Object[]> selectAllSach(String maS, String key) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                if (key.equalsIgnoreCase("DESC")) {
                    String sql = "SELECT TOP(10) Sach.MaSach AS 'MaSach', TenSach, TenTheLoai, TenTacGia, TenNhaXuatBan, NgayNhap, dbo.Sach.SoLuong AS 'SoLuong', dbo.Sach.SoLuong AS 'SoLuongTon' FROM dbo.Sach JOIN dbo.TacGia ON TacGia.MaTacGia = Sach.MaTacGia JOIN dbo.TheLoaiSach ON TheLoaiSach.MaTheLoai = Sach.MaTheLoai JOIN dbo.NhaXuatBan ON NhaXuatBan.MaNhaXuatBan = Sach.MaNhaXuatBan WHERE dbo.Sach.TenSach LIKE ? OR dbo.Sach.MaSach LIKE ? ORDER BY SoLuong DESC";
                    rs = Xjdbc.query(sql, "%" + maS + "%", "%" + maS + "%");
                } else if (key.equalsIgnoreCase("ASC")) {
                    String sql = "SELECT TOP(10) Sach.MaSach AS 'MaSach', TenSach, TenTheLoai, TenTacGia, TenNhaXuatBan, NgayNhap, dbo.Sach.SoLuong AS 'SoLuong', dbo.Sach.SoLuong AS 'SoLuongTon' FROM dbo.Sach JOIN dbo.TacGia ON TacGia.MaTacGia = Sach.MaTacGia JOIN dbo.TheLoaiSach ON TheLoaiSach.MaTheLoai = Sach.MaTheLoai JOIN dbo.NhaXuatBan ON NhaXuatBan.MaNhaXuatBan = Sach.MaNhaXuatBan WHERE dbo.Sach.TenSach LIKE ? OR dbo.Sach.MaSach LIKE ? ORDER BY SoLuong ASC";
                    rs = Xjdbc.query(sql, "%" + maS + "%", "%" + maS + "%");
                } else {
                    String sql = "SELECT Sach.MaSach AS 'MaSach', TenSach, TenTheLoai, TenTacGia, TenNhaXuatBan, NgayNhap, dbo.Sach.SoLuong AS 'SoLuong', dbo.Sach.SoLuong AS 'SoLuongTon' FROM dbo.Sach JOIN dbo.TacGia ON TacGia.MaTacGia = Sach.MaTacGia JOIN dbo.TheLoaiSach ON TheLoaiSach.MaTheLoai = Sach.MaTheLoai JOIN dbo.NhaXuatBan ON NhaXuatBan.MaNhaXuatBan = Sach.MaNhaXuatBan WHERE dbo.Sach.TenSach LIKE ? OR dbo.Sach.MaSach LIKE ?";
                    rs = Xjdbc.query(sql, "%" + maS + "%", "%" + maS + "%");
                }

                while (rs.next()) {
                    Object[] ob = new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        (Integer.valueOf((String) rs.getString(8)) - selectSluongMuon(rs.getString(1).toString()))

                    };

                    list.add(ob);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public int selectSluongMuon(String ma) {
        int ob = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT SUM(SoLuong) FROM dbo.ChiTietPhieuMuon WHERE MaSach = ? GROUP BY MaSach ";
                rs = Xjdbc.query(sql, ma);
                while (rs.next()) {
                    ob = Integer.valueOf(rs.getString(1).toString());
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ob;
    }

    public static void main(String[] args) {
        System.out.println("sv: " + new SvSachDAO().selectSluongMuon("S001"));
    }
}
