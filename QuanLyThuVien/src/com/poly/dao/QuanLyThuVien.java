/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import java.util.List;

/**
 *
 * @author hma20
 */
abstract public class QuanLyThuVien <EntityType, KeyType> {
    abstract public void insert(EntityType entity);
    abstract public void update (EntityType entity);
    abstract public void delete (KeyType id);
    abstract public EntityType selectById (KeyType id);
    abstract public List<EntityType> selectAll();
    abstract public List<EntityType> selectBySql(String sql, Object...args);    
}
