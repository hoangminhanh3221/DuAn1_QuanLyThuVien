/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.XDate;
import com.poly.helper.Xjdbc;
import com.poly.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author php89
 */
public class NhanVienDAO extends QuanLyThuVien<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET tenNhanVien = ?,diaChi = ?, gioiTinh = ?, email = ?, matKhau = ?, soDienThoai = ?, hinh = ?, ngaySinh = ? WHERE maNhanVien = ?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE maNhanVien = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    
    @Override
    public void insert(NhanVien entity) {
        try {
            Xjdbc.update(INSERT_SQL,
                    entity.getMaNhanVien(),
                    entity.getTenNhanVien(),
                    entity.getMatKhau(),
                    entity.getNgaySinh(),
                    entity.isGioiTinh(),
                    entity.getDiaChi(),   
                    entity.getEmail(),
                    entity.getSoDienThoai(),
                    entity.getHinhAnh());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            Xjdbc.update(UPDATE_SQL,
                    entity.getTenNhanVien(),
                    entity.getDiaChi(),
                    entity.isGioiTinh(),
                    entity.getEmail(),
                    entity.getMatKhau(),
                    entity.getSoDienThoai(),
                    entity.getHinhAnh(),
                    entity.getNgaySinh(),
                    entity.getMaNhanVien());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }

    @Override
    public void delete(String id) {
        try {
            Xjdbc.update(DELETE_SQL,id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = (List<NhanVien>) this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return (List<NhanVien>) this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNhanVien(rs.getString("maNhanVien"));
                entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                entity.setDiaChi(rs.getString("diaChi"));
                entity.setEmail(rs.getString("email"));
                entity.setHinhAnh(rs.getString("hinh"));
                entity.setMatKhau(rs.getString("matKhau"));
                entity.setSoDienThoai(rs.getString("soDienThoai"));
                entity.setNgaySinh(XDate.toString(rs.getDate("ngaySinh"), "dd/MM/yyyy"));
                entity.setTenNhanVien(rs.getString("tenNhanVien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
