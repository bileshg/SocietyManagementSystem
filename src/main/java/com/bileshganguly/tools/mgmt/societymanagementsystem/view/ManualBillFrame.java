/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.view;

import com.bileshganguly.tools.mgmt.societymanagementsystem.config.ManageConfig;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Configuration;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Flat;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.ManualBill;
import com.bileshganguly.tools.mgmt.societymanagementsystem.sql.DatabaseConnection;
import com.bileshganguly.tools.mgmt.societymanagementsystem.sql.ManualBillSQL;
import com.bileshganguly.tools.mgmt.societymanagementsystem.util.AmountInWords;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author bilesh
 */
public class ManualBillFrame extends javax.swing.JFrame {

    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final String[] fullMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private List<ManualBill> manualBills = new LinkedList<>();
    private final Map<String, Double> otherCharges = new HashMap<>();

    private Configuration configuration;
    private final Flat flat;

    private String today;

    private final String fromMonthYear;
    private final String toMonthYear;

    private final boolean isReceipt;

    private JPanel container;
    private JLabel lableBill;
    private JButton printButton;
    private JScrollPane scrollPane;

    /**
     * Creates new form BillFrame
     *
     * @param flat
     * @param fromMonthYear
     * @param toMothYear
     * @param isReceipt
     */
    public ManualBillFrame(Flat flat, String fromMonthYear, String toMothYear, boolean isReceipt) {
        this.flat = flat;
        this.fromMonthYear = fromMonthYear;
        this.toMonthYear = toMothYear;
        this.isReceipt = isReceipt;
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receipt");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManualBillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManualBillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManualBillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManualBillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManualBillFrame(null, "Jan 2017", "Jan 2018", false).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private String billHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>"
                + "<style type='text/css'>"
                + "body, h1, th, td {"
                + "  font-family: Serif;"
                + "  font-size: 8pt;"
                + "  line-height: 1em;"
                + "}"
                + "#firstHeading {"
                + "  font-size: 12pt;"
                + "  font-weight: bold;"
                + "  line-height: 1.15em;"
                + "}"
                + "#secondHeading {"
                + "  font-size: 10pt;"
                + "  font-weight: bold;"
                + "  line-height: 1.15em;"
                + "}"
                + "th {"
                + "  border-bottom: thin solid gray;"
                + "}"
                + ".overline td {"
                + "  border-top: thin solid gray;"
                + "}"
                + "</style>"
                + "<body>");
        sb.append("<p id='firstHeading' align='center'>" + configuration.getBuildingName() + "</p><hr width=80% />"
                + "<p id='secondHeading' align='center'>" + configuration.getBuildingAddress() + "</p>"
                + "<p id='secondHeading' align='center'>Reg. No.: " + configuration.getBuildingRegNo() + "</p>"
                + "<br/>"
                + "<p align='right'>Date: " + today + "</p><br/>"
                + "<p>To,</p>"
                + "<p>&nbsp;&nbsp;" + flat.getName() + "</p><br/>"
                + "<p>&nbsp;&nbsp;" + (isReceipt ? "Receipt" : "Bill") + " for Society Charges from \"" + fromMonthYear + "\" to \"" + toMonthYear + "\" for Flat No \"" + flat.getFlatNumber() + "\"</p>"
                + "<br/>");

        sb.append("<table width='450' cellspacing='0' cellpadding='2'>"
                + "<tr>"
                + "<th width='10%' align='center'>Sr. No.</th>"
                + "<th></th>"
                + "<th width='50%' align='left'>Month/Year</th>"
                + "<th width='40%' align='right'>Amount (Rs.)</th>"
                + "</tr>");
        int count = 1;
        for (ManualBill mBills : manualBills) {
            sb.append("<tr>"
                    + "<td align='right'>")
                    .append(count++ + ". ")
                    .append("</td><td></td>"
                            + "<td>")
                    .append(fullMonths[mBills.getMonth() - 1])
                    .append(" ")
                    .append(mBills.getYear())
                    .append("</td>"
                            + "<td align='right'>")
                    .append(formatDouble(mBills.getAmount()))
                    .append("</td>"
                            + "</tr>");
        }
        for (Entry<String, Double> mBills : otherCharges.entrySet()) {
            sb.append("<tr>"
                    + "<td align='right'>")
                    .append(count++ + ". ")
                    .append("</td><td></td>"
                            + "<td>")
                    .append(mBills.getKey())
                    .append("</td>"
                            + "<td align='right'>")
                    .append(formatDouble(mBills.getValue()))
                    .append("</td>"
                            + "</tr>");
        }

        sb.append("<tr class='overline'>"
                + "<td>&nbsp;")
                .append("</td><td></td>"
                        + "<td align='right'>")
                .append("Grand Total")
                .append("</td>"
                        + "<td align='right'>")
                .append(formatAmount(calculate()))
                .append("</td>"
                        + "</tr>"
                        + "</table>");
        sb.append("<br/>Amount in words: Rupees " + AmountInWords.convert((int) calculate()) + " Only<br/>"
                + "<br/><p>Thanking you,</p><br/>"
                + "<p>For<p><br/>"
                + "<p>" + configuration.getBuildingName() + "</p><br/>"
                + "<p>This is a computer generated " + (isReceipt ? "Receipt" : "Bill") + " which needs no signature.</p>");

        return sb.toString();
    }

    private String formatDouble(double amount) {
        String pattern = "##,##,##,###.00";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(amount);
        //return new MessageFormat("{0,number}").format(new Object[]{amount});
    }

    private String formatAmount(double amount) {
        String pattern = "\u20B9##,##,##,###.00";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(amount);
        //return new MessageFormat("Rs.{0,number}").format(new Object[]{amount});
    }

    private void init() {
        ManageConfig manageConfig = new ManageConfig();
        configuration = manageConfig.getConfiguration();

        int from = Integer.parseInt(fromMonthYear.split(" ")[1]) * 100 + Arrays.asList(months).indexOf(fromMonthYear.split(" ")[0]) + 1;
        int to = Integer.parseInt(toMonthYear.split(" ")[1]) * 100 + Arrays.asList(months).indexOf(toMonthYear.split(" ")[0]) + 1;

        DatabaseConnection databaseConnection = new DatabaseConnection();
        if (databaseConnection.connect()) {
            ManualBillSQL manualBillSql = new ManualBillSQL(databaseConnection);
            manualBills = manualBillSql.getById(flat.getFlatNumber(), from, to);
        }

        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("dd/MM/yyyy");

        today = ft.format(dNow);

        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().setLayout(new FlowLayout());

        populateScrollpane();
    }

    private void populateScrollpane() {
        container = new JPanel();
        container.setBorder(BorderFactory.createEmptyBorder());
        container.setBackground(Color.WHITE);
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        lableBill = new JLabel(billHTML());
        lableBill.setBorder(BorderFactory.createEmptyBorder());
        container.add(lableBill);

        printButton = new JButton("Print");
        printButton.addActionListener((ActionEvent e) -> {
            print();
        });
        container.add(printButton);

        scrollPane = new JScrollPane(container);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane);
    }

    private double calculate() {
        double total = 0;
        total = manualBills.stream().map((mb) -> mb.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
        total = otherCharges.entrySet().stream().map((entry) -> entry.getValue()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }

    private void addRecord() {
        String particular = JOptionPane.showInputDialog("Particulars");
        try {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Amount"));
            otherCharges.put(particular, amount);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Enter only numbers", JOptionPane.ERROR_MESSAGE);
        }
        lableBill.setText(billHTML());
    }

    private void print() {
        try {
            JTextPane jtp = new JTextPane();
            jtp.setContentType("text/html");
            jtp.setText(billHTML());
            jtp.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
