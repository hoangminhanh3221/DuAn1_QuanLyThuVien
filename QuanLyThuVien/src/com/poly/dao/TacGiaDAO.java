package com.poly.dao;


import com.poly.dao.QuanLyThuVien;
import com.poly.helper.*;
import com.poly.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author php89
 */
public class TacGiaDAO extends QuanLyThuVien<TacGia, String>{
    String INSERT_SQL = "INSERT INTO tacGia VALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE tacGia SET tenTacGia = ?, gioiTinh = ?, ngaySinh = ? WHERE maTacGia = ?";
    String DELETE_SQL = "DELETE FROM tacGia WHERE maTacGia = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM tacgia WHERE maTacGia = ?";
    String SELECT_ALL_SQL = "SELECT * FROM tacGia";
    
    @Override
    public void insert(TacGia entity) {
        try {
            Xjdbc.update(INSERT_SQL,
                    entity.getMaTacGia(),
                    entity.getTenTacGia(),
                    entity.isGioiTinh(),
                    entity.getNgaySinh());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(TacGia entity) {
        try {
            Xjdbc.update(UPDATE_SQL,
                    entity.getTenTacGia(),
                    entity.isGioiTinh(),
                    entity.getNgaySinh(),
                    entity.getMaTacGia());
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
    public TacGia selectById(String id) {
        List<TacGia> list = (List<TacGia>) this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TacGia> selectAll() {
        return (List<TacGia>) this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<TacGia> selectBySql(String sql, Object... args) {
        List<TacGia> list = new ArrayList<TacGia>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                TacGia entity = new TacGia();
                entity.setMaTacGia(rs.getString("maTacGia"));
                entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                entity.setNgaySinh(XDate.toString(rs.getDate("ngaySinh"), "dd/MM/yyyy"));
                entity.setTenTacGia(rs.getString("tenTacGia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
