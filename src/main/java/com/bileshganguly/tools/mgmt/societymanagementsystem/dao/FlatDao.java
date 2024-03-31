/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.dao;

import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Flat;
import java.util.List;

/**
 *
 * @author bilesh
 */
public interface FlatDao {
    List<Flat> getAll();
    List<Flat> getById(int id);
    List<Flat> getByName(String name);
    boolean insert(Flat flat);
    boolean update(Flat flat);
    boolean delete(Flat flat);    
}
