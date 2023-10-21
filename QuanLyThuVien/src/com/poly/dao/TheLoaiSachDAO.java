/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.TheLoaiSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC
 */
public class TheLoaiSachDAO extends QuanLyThuVien<TheLoaiSach, String>{
    String INSERT_SQL = "insert into TheLoaiSach(MaTheLoai, TenTheLoai, ViTri) values (?, ?, ?)";
    String UPDATE_SQL = "update TheLoaiSach set TenTheLoai=?, ViTri=? where MaTheLoai = ?";
    String DELETE_SQL = "delete from TheLoaiSach where MaTheLoai = ?";
    String SELECT_ALL_SQL = "select * from TheLoaiSach";
    String SELECT_BY_ID_SQL = "select * from TheLoaiSach where MaTheLoai = ?";

    @Override
    public void insert(TheLoaiSach entity) {
        try {
            Xjdbc.update(
                    INSERT_SQL,
                    entity.getMaTheLoai(),
                    entity.getTenTheLoai(),
                    entity.getViTri()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TheLoaiSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TheLoaiSach entity) {
         try {
            Xjdbc.update(
                    UPDATE_SQL,
                    entity.getTenTheLoai(),
                    entity.getViTri(),
                    entity.getMaTheLoai()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TheLoaiSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void delete(String id) {
        try {
            Xjdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TheLoaiSach selectById(String id) {
        List<TheLoaiSach> list = selectBySql(SELECT_BY_ID_SQL, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<TheLoaiSach> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<TheLoaiSach> selectBySql(String sql, Object... args) {
        List<TheLoaiSach> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    TheLoaiSach entity = new TheLoaiSach(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3)
                    );
                    list.add(entity);
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
    public boolean checkMaTheLoai(String maTLS) {
        boolean isCheck = false;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_CheckMaTheLoai (?)}";
                rs = Xjdbc.query(sql, maTLS);
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
