/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hma20
 */
public class TKPhieuMuonDAO {
    
    public List<PhieuMuon> selectAll() {
        List<PhieuMuon> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from PhieuMuon";
                rs = Xjdbc.query(sql);
                while(rs.next()){
                    PhieuMuon entity = new PhieuMuon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBoolean(7)
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
    
    public List<PhieuMuon> selectBySQL(String sql, Object... args) {
        List<PhieuMuon> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    PhieuMuon entity = new PhieuMuon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBoolean(7)
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
    
    public List<PhieuMuon> selectCBOLuaChon(String sql) {
        List<PhieuMuon> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql);
                while(rs.next()){
                    PhieuMuon entity = new PhieuMuon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBoolean(7)
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
}
