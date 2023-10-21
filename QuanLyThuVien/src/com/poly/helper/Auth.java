/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.helper;

import com.poly.model.NhanVien;
import com.poly.model.SinhVien;



/**
 *
 * @author ADMIN
 */
public class Auth {
    public static NhanVien nv = null;
    public static SinhVien sv = null;
    public static void clear(){
        Auth.nv = null;
    }
    public static boolean islogin(){
        return Auth.nv != null;
    }
}
