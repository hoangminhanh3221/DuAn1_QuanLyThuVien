/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.helper.Xjdbc;
import com.poly.model.SinhVien;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SinhVienDAO{
     String UPDATE_SQL = "UPDATE SinhVien SET MatKhau=?, TenSinhVien = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, Email = ?, SoDienThoai = ?, Hinh = ? WHERE MaSinhVien = ?";
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public boolean update(SinhVien entity, String ma) {
        try {
           return Xjdbc.update(UPDATE_SQL,
                    entity.getMatKhau(),
                    entity.getTenSinhVien(),
                    new java.sql.Date(sdf.parse(entity.getNgaySinh()).getTime()),
                    entity.isGioiTinh(),
                    entity.getDiaChi(),
                    entity.getEmail(),
                    entity.getSoDienThoai(),
                    entity.getHinhAnh(),
                    ma) > 0;
         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
