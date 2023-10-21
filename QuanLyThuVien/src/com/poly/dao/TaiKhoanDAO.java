/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.XDate;
import com.poly.model.NhanVien;
import java.sql.ResultSet;
import com.poly.helper.Xjdbc;
import com.poly.model.SinhVien;

/**
 *
 * @author Trinh Dat Dat
 */
public class TaiKhoanDAO {
    
    public NhanVien logInNV(String tenDangNhap){
        try {
            String sql = "select * from NhanVien where MaNhanVien = ?";
            ResultSet rs = Xjdbc.query(sql, tenDangNhap);
            NhanVien nv = new NhanVien();
            if (rs.next()) {
               nv.setMaNhanVien(rs.getString(1));
               nv.setTenNhanVien(rs.getString(2));
               nv.setMatKhau(rs.getString(3));
               nv.setNgaySinh(XDate.toString(rs.getDate(4), "dd/MM/yyyy"));
               nv.setGioiTinh(rs.getBoolean(5));
               nv.setDiaChi(rs.getString(6));
               nv.setEmail(rs.getString(7));
               nv.setSoDienThoai(rs.getString(8));
               nv.setHinhAnh(rs.getString(9));
            }
            rs.getStatement().getConnection().close();
            return nv;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public SinhVien logInSV(String tenDangNhap){
        try {
            String sql = "select * from SinhVien where MaSinhVien = ?";
            ResultSet rs = Xjdbc.query(sql, tenDangNhap);
            SinhVien sv = new SinhVien();
            if (rs.next()) {
                sv.setMaSinhVien(rs.getString(1));
                sv.setMatKhau(rs.getString(2));
                sv.setTenSinhVien(rs.getString(3));
                sv.setNgaySinh(XDate.toString(rs.getDate(4), "dd/MM/yyyy"));
                sv.setGioiTinh(rs.getBoolean(5));
                sv.setDiaChi(rs.getString(6));
                sv.setEmail(rs.getString(7));
                sv.setSoDienThoai(rs.getString(8));
                sv.setHinhAnh(rs.getString(9));
               
            }
            rs.getStatement().getConnection().close();
            return sv;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void DoiMK_SV(String maSV, String matKhau){
        String UPDATE_SQL ="update SinhVien set matKhau = ? where MaSinhVien = ?";
        try {
            Xjdbc.update(
                    UPDATE_SQL,
                    matKhau,
                    maSV
            );
            System.out.println("update");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    
    public void DoiMK_NV(String maNV, String matKhau){
        String UPDATE_SQL ="update NhanVien set matKhau = ? where MaNhanVien = ?";
        try {
            Xjdbc.update(
                    UPDATE_SQL,
                    matKhau,
                    maNV
                    
            );
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    public boolean emailNV(String mail){
        try {
            String sql = "select * from NhanVien where Email = ?";
            ResultSet rs = Xjdbc.query(sql, mail);
            if (rs.next()) {
                System.out.println("true");
                return true;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
