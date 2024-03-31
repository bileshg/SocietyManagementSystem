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
public class ManualBill {
    
    private int id;
    private int month;
    private int year;
    private int monthyear;
    private String flat_number;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonthyear() {
        return monthyear;
    }

    public void setMonthyear(int monthyear) {
        this.monthyear = monthyear;
    }

    public String getFlatNumber() {
        return flat_number;
    }

    public void setFlatNumber(String flat_number) {
        this.flat_number = flat_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
