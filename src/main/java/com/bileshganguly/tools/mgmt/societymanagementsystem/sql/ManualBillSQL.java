/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.sql;

import com.bileshganguly.tools.mgmt.societymanagementsystem.model.ManualBill;
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
public class ManualBillSQL {    

    private final DatabaseConnection databaseConnection;

    private PreparedStatement getRecords = null;
    
    private final String selectByFlatNumber =   "select * from manual_bills " +
                                                "where flat_number = ? " +
                                                "and monthyear >= ? and monthyear <= ?";

    public ManualBillSQL() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    public ManualBillSQL(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<ManualBill> getById(String flatNumber, int from, int to) {
        List<ManualBill> manualBills = new ArrayList<>();

        try {
            getRecords = databaseConnection.getConnection().prepareStatement(selectByFlatNumber);
            getRecords.setInt(1, Integer.parseInt(flatNumber));
            getRecords.setInt(2, from);
            getRecords.setInt(3, to);
            ResultSet resultSet = getRecords.executeQuery();
            while (resultSet.next()) {
                ManualBill manualBill = new ManualBill();
                manualBill.setId(resultSet.getInt("id"));
                manualBill.setFlatNumber(Integer.toString(resultSet.getInt("flat_number")));
                manualBill.setMonth(resultSet.getInt("month"));
                manualBill.setYear(resultSet.getInt("year"));
                manualBill.setMonthyear(resultSet.getInt("monthyear"));
                manualBill.setAmount(resultSet.getDouble("amount"));
                manualBills.add(manualBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManualBillSQL.class.getName()).log(Level.SEVERE, "Failed to fetch records!", ex);
        }

        return manualBills;
    }
}
