/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author php89
 */
public class NhaXuatBanDAO extends QuanLyThuVien<NhaXuatBan, String>{
    String INSERT_SQL = "INSERT INTO nhaXuatBan VALUES(?,?)";
    String UPDATE_SQL = "UPDATE nhaXuatBan SET tenNhaXuatBan = ? WHERE maNhaXuatBan = ?";
    String DELETE_SQL = "DELETE FROM nhaXuatBan WHERE maNhaXuatBan = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM nhaXuatBan WHERE maNhaXuatBan = ?";
    String SELECT_ALL_SQL = "SELECT * FROM nhaXuatBan";
    
    @Override
    public void insert(NhaXuatBan entity) {
        try {
            Xjdbc.update(INSERT_SQL,
                    entity.getMaNhaXuatBan(),
                    entity.getTenNhaXuatBan());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(NhaXuatBan entity) {
        try {
            Xjdbc.update(UPDATE_SQL,
                    entity.getTenNhaXuatBan(),
                    entity.getMaNhaXuatBan());
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
    public NhaXuatBan selectById(String id) {
        List<NhaXuatBan> list = (List<NhaXuatBan>) this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaXuatBan> selectAll() {
        return (List<NhaXuatBan>) this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NhaXuatBan> selectBySql(String sql, Object... args) {
        List<NhaXuatBan> list = new ArrayList<NhaXuatBan>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                NhaXuatBan entity = new NhaXuatBan();
                entity.setMaNhaXuatBan(rs.getString("maNhaXuatBan"));
                entity.setTenNhaXuatBan(rs.getString("tenNhaXuatBan"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
}
