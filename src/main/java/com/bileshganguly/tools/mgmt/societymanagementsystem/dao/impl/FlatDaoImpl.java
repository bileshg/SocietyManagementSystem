/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.dao.impl;

import com.bileshganguly.tools.mgmt.societymanagementsystem.dao.FlatDao;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Flat;
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
public class FlatDaoImpl implements FlatDao {

    private final DatabaseConnection databaseConnection;

    private PreparedStatement insertFlat = null;
    private PreparedStatement updateFlat = null;
    private PreparedStatement deleteFlat = null;

    private PreparedStatement selectFlat = null;
    private PreparedStatement selectByIdFlat = null;
    private PreparedStatement selectByNameFlat = null;

    private final String insertString = "INSERT INTO flat(flat_number, name, area, email_id, phone_no) VALUES(?,?,?,?,?);";
    private final String updateString = "UPDATE flat SET flat_number = ?, name = ?, area = ?, email_id = ?, phone_no = ? WHERE id = ?;";
    private final String deleteString = "DELETE FROM flat WHERE id = ?;";

    private final String selectString = "SELECT * FROM flat;";
    private final String selectByIdString = "SELECT * FROM flat WHERE id = ?;";
    private final String selectByNameString = "SELECT * FROM flat WHERE flat_number = ?;";

    public FlatDaoImpl() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    public FlatDaoImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean insert(Flat flat) {
        try {
            insertFlat = databaseConnection.getConnection().prepareStatement(insertString);
            insertFlat.setString(1, flat.getFlatNumber());
            insertFlat.setString(2, flat.getName());
            insertFlat.setDouble(3, flat.getArea());
            insertFlat.setString(4, flat.getEmailId());
            insertFlat.setString(5, flat.getPhoneNo());
            insertFlat.executeUpdate();
            ResultSet rs = insertFlat.getGeneratedKeys();
            if(rs.next()) flat.setFlatId(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to insert record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Flat flat) {
        try {
            updateFlat = databaseConnection.getConnection().prepareStatement(updateString);
            updateFlat.setString(1, flat.getFlatNumber());
            updateFlat.setString(2, flat.getName());
            updateFlat.setDouble(3, flat.getArea());
            updateFlat.setString(4, flat.getEmailId());
            updateFlat.setString(5, flat.getPhoneNo());
            updateFlat.setInt(6, flat.getFlatId());
            updateFlat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to update record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Flat flat) {
        try {
            deleteFlat = databaseConnection.getConnection().prepareStatement(deleteString);
            deleteFlat.setInt(1, flat.getFlatId());
            deleteFlat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to delete record!", ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Flat> getAll() {
        List<Flat> flats = new ArrayList<>();

        try {
            selectFlat = databaseConnection.getConnection().prepareStatement(selectString);
            ResultSet resultSet = selectFlat.executeQuery();
            while (resultSet.next()) {
                Flat newFlat = new Flat();
                newFlat.setFlatId(resultSet.getInt("id"));
                newFlat.setFlatNumber(resultSet.getString("flat_number"));
                newFlat.setName(resultSet.getString("name"));
                newFlat.setArea(resultSet.getDouble("area"));
                newFlat.setEmailId(resultSet.getString("email_id"));
                newFlat.setPhoneNo(resultSet.getString("phone_no"));
                flats.add(newFlat);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);
        }

        return flats;
    }

    @Override
    public List<Flat> getById(int id) {
        List<Flat> flats = new ArrayList<>();

        try {
            selectByIdFlat = databaseConnection.getConnection().prepareStatement(selectByIdString);
            selectByIdFlat.setInt(1, id);
            ResultSet resultSet = selectFlat.executeQuery();
            while (resultSet.next()) {
                Flat newFlat = new Flat();
                newFlat.setFlatId(resultSet.getInt("id"));
                newFlat.setFlatNumber(resultSet.getString("flat_number"));
                newFlat.setName(resultSet.getString("name"));
                newFlat.setArea(resultSet.getDouble("area"));
                newFlat.setEmailId(resultSet.getString("email_id"));
                newFlat.setPhoneNo(resultSet.getString("phone_no"));
                flats.add(newFlat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);
        }

        return flats;
    }

    @Override
    public List<Flat> getByName(String name) {
        List<Flat> flats = new ArrayList<>();

        try {
            selectByNameFlat = databaseConnection.getConnection().prepareStatement(selectByNameString);
            selectByNameFlat.setString(1, name);
            ResultSet resultSet = selectByNameFlat.executeQuery();
            while (resultSet.next()) {
                Flat newFlat = new Flat();
                newFlat.setFlatId(resultSet.getInt("id"));
                newFlat.setFlatNumber(resultSet.getString("flat_number"));
                newFlat.setName(resultSet.getString("name"));
                newFlat.setArea(resultSet.getDouble("area"));
                newFlat.setEmailId(resultSet.getString("email_id"));
                newFlat.setPhoneNo(resultSet.getString("phone_no"));
                flats.add(newFlat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlatDaoImpl.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);
        }

        return flats;
    }

}
