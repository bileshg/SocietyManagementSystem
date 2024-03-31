/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.dao;

import com.bileshganguly.tools.mgmt.societymanagementsystem.model.ChargeType;
import java.util.List;

/**
 *
 * @author bilesh
 */
public interface ChargeTypeDao {
    List<ChargeType> getAll();
    List<ChargeType> getById(int id);
    List<ChargeType> getByName(String name);
    boolean insert(ChargeType chargeType);
    boolean update(ChargeType chargeType);
    boolean delete(ChargeType chargeType);
}
