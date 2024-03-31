/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.config;

import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author bilesh
 */
public class ManageConfig {

    private static final String FILENAME = "config.properties";

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();

        Properties prop = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get(FILENAME))) {

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and set it to the object
            configuration.setBuildingName(prop.getProperty("building.name"));
            configuration.setBuildingAddress(prop.getProperty("building.address"));
            configuration.setBuildingRegNo(prop.getProperty("building.regno"));
            configuration.setFixedRate(Double.parseDouble(prop.getProperty("fixed.rate")));
            configuration.setTenantRate(Double.parseDouble(prop.getProperty("tenant.rate")));
            configuration.setParkingAmount(Double.parseDouble(prop.getProperty("parking.amount")));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Config Error", JOptionPane.ERROR_MESSAGE);
        }

        return configuration;
    }

    public void setConfiguration(final Configuration configuration) {
        Properties prop = new Properties();

        try (OutputStream output = Files.newOutputStream(Paths.get(FILENAME))) {

            // set the properties value
            prop.setProperty("building.name", configuration.getBuildingName());
            prop.setProperty("building.address", configuration.getBuildingAddress());
            prop.setProperty("building.regno", configuration.getBuildingRegNo());
            prop.setProperty("fixed.rate", Double.toString(configuration.getFixedRate()));
            prop.setProperty("tenant.rate", Double.toString(configuration.getTenantRate()));
            prop.setProperty("parking.amount", Double.toString(configuration.getParkingAmount()));

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, io.getMessage(), "Config Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please enter only numbers in the fixed and tenant rate fields.", "Config Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
