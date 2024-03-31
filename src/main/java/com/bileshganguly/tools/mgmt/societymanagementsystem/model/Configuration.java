/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.model;

/**
 *
 * @author bilesh
 */
public class Configuration {

    private String buildingName;
    private String buildingAddress;
    private String buildingRegNo;
    private double fixedRate;
    private double tenantRate;
    private double parkingAmount;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getBuildingRegNo() {
        return buildingRegNo;
    }

    public void setBuildingRegNo(String buildingRegNo) {
        this.buildingRegNo = buildingRegNo;
    }

    public double getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    public double getTenantRate() {
        return tenantRate;
    }

    public void setTenantRate(double tenantRate) {
        this.tenantRate = tenantRate;
    }

    public double getParkingAmount() {
        return parkingAmount;
    }

    public void setParkingAmount(double parkingAmount) {
        this.parkingAmount = parkingAmount;
    }
    
}
