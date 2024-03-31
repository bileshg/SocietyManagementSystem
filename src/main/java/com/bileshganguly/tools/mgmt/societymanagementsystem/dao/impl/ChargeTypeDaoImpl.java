/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.dao.impl;

import com.bileshganguly.tools.mgmt.societymanagementsystem.dao.ChargeTypeDao;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.ChargeType;
import com.bileshganguly.tools.mgmt.societymanagementsystem.sql.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilesh
 */
public class ChargeTypeDaoImpl implements ChargeTypeDao {

    private final DatabaseConnection databaseConnection;
    
    private PreparedStatement insertChargeType = null;
    private PreparedStatement updateChargeType = null;
    private PreparedStatement deleteChargeType = null;
    
    private PreparedStatement selectChargeType = null;
    private PreparedStatement selectByIdChargeType = null;
    private PreparedStatement selectByNameChargeType = null;
    
    private final String insertString = "INSERT INTO charge_type(type_name, type_desc, amount) VALUES(?,?,?);";
    private final String updateString = "UPDATE charge_type SET type_name = ?, type_desc = ?, amount = ? WHERE id = ?;";
    private final String deleteString = "DELETE FROM charge_type WHERE id = ?;";
    
    private final String selectString = "SELECT * FROM charge_type;";
    private final String selectByIdString = "SELECT * FROM charge_type WHERE id = ?;";
    private final String selectByNameString = "SELECT * FROM charge_type WHERE type_name = ?;";

    public ChargeTypeDaoImpl() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    public ChargeTypeDaoImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean insert(ChargeType chargeType) {
        try {
            insertChargeType = databaseConnection.getConnection().prepareStatement(insertString);
            insertChargeType.setString(1, chargeType.getTypeName());
            insertChargeType.setString(2, chargeType.getTypeDesc());
            insertChargeType.setDouble(3, chargeType.getAmount());
            insertChargeType.executeUpdate();
            ResultSet rs = insertChargeType.getGeneratedKeys();
            if(rs.next()) chargeType.setTypeId(rs.getInt(1));
        } catch (SQLException ex) {            
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to insert record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ChargeType chargeType) {
        try {
            updateChargeType = databaseConnection.getConnection().prepareStatement(updateString);
            updateChargeType.setString(1, chargeType.getTypeName());
            updateChargeType.setString(2, chargeType.getTypeDesc());
            updateChargeType.setDouble(3, chargeType.getAmount());
            updateChargeType.setInt(4, chargeType.getTypeId());
            updateChargeType.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to update record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ChargeType chargeType) {
        try {
            deleteChargeType = databaseConnection.getConnection().prepareStatement(deleteString);
            deleteChargeType.setInt(1, chargeType.getTypeId());
            deleteChargeType.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to delete record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public List<ChargeType> getAll() {
        List<ChargeType> chargeTypes = new ArrayList<>();
        
        try {
            selectChargeType = databaseConnection.getConnection().prepareStatement(selectString);
            ResultSet resultSet = selectChargeType.executeQuery();
            while(resultSet.next()) {
                ChargeType newChargeType = new ChargeType();
                newChargeType.setTypeId(resultSet.getInt("id"));
                newChargeType.setTypeName(resultSet.getString("type_name"));
                newChargeType.setTypeDesc(resultSet.getString("type_desc"));
                newChargeType.setAmount(resultSet.getDouble("amount"));
                chargeTypes.add(newChargeType);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);            
        }       
        
        return chargeTypes;
    }

    @Override
    public List<ChargeType> getById(int id) {
        List<ChargeType> chargeTypes = new ArrayList<>();
        
        try {
            selectByIdChargeType = databaseConnection.getConnection().prepareStatement(selectByIdString);
            selectByIdChargeType.setInt(1, id);
            ResultSet resultSet = selectChargeType.executeQuery();
            while(resultSet.next()) {
                ChargeType newChargeType = new ChargeType();
                newChargeType.setTypeId(resultSet.getInt("id"));
                newChargeType.setTypeName(resultSet.getString("type_name"));
                newChargeType.setTypeDesc(resultSet.getString("type_desc"));
                newChargeType.setAmount(resultSet.getDouble("amount"));
                chargeTypes.add(newChargeType);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);                
        }       
        
        return chargeTypes;
    }

    @Override
    public List<ChargeType> getByName(String name) {
        List<ChargeType> chargeTypes = new ArrayList<>();
        
        try {
            selectByNameChargeType = databaseConnection.getConnection().prepareStatement(selectByNameString);
            selectByNameChargeType.setString(1, name);
            ResultSet resultSet = selectByNameChargeType.executeQuery();
            while(resultSet.next()) {
                ChargeType newChargeType = new ChargeType();
                newChargeType.setTypeId(resultSet.getInt("id"));
                newChargeType.setTypeName(resultSet.getString("type_name"));
                newChargeType.setTypeDesc(resultSet.getString("type_desc"));
                newChargeType.setAmount(resultSet.getDouble("amount"));
                chargeTypes.add(newChargeType);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChargeTypeDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);                
        }       
        
        return chargeTypes;
    }
    
}
