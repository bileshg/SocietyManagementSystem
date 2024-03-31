/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.view;

import com.bileshganguly.tools.mgmt.societymanagementsystem.dao.impl.FlatDaoImpl;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Flat;
import com.bileshganguly.tools.mgmt.societymanagementsystem.sql.DatabaseConnection;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author bilesh
 */
public class MainFrame extends javax.swing.JFrame {

    private DatabaseConnection databaseConnection;
    private FlatDaoImpl dbFlat;

    private List<Flat> flats = new LinkedList<>();
    private String[] flatNumbers;

    private final String[] types = {"Fixed", "Variable"};

    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        labelFlatNo = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        cbFlatNo = new javax.swing.JComboBox<>();
        cbType = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbParking = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbToYear = new javax.swing.JComboBox<>();
        cbToMonth = new javax.swing.JComboBox<>();
        btGenerate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        checkTenant = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemConfig = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        menuItemChargeType = new javax.swing.JMenuItem();
        menuItemFlat = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Society Management System");

        labelFlatNo.setText("Flat Number");

        labelType.setText("Type");

        cbFlatNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(types));

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(months));

        jLabel1.setText("From");

        jLabel2.setText("To");

        cbParking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel3.setText("Extra Parking");

        cbToYear.setModel(new javax.swing.DefaultComboBoxModel<>());

        cbToMonth.setModel(new javax.swing.DefaultComboBoxModel<>(months));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFlatNo)
                    .addComponent(labelType)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbParking, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFlatNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbToYear, javax.swing.GroupLayout.Alignment.LEADING, 0, 104, Short.MAX_VALUE)
                            .addComponent(cbYear, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbToMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFlatNo)
                    .addComponent(cbFlatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelType)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbToYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbToMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbParking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        btGenerate.setText("Generate Bill");
        btGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerateActionPerformed(evt);
            }
        });

        jButton1.setText("Generate Receipt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkTenant.setText("Check if tenant");

        jMenu1.setText("File");

        menuItemConfig.setText("Configuration");
        menuItemConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConfigActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemConfig);
        jMenu1.add(jSeparator1);

        menuItemExit.setText("Close");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        menuMaster.setText("Master");

        menuItemChargeType.setText("Charge Type Master");
        menuItemChargeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemChargeTypeActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemChargeType);

        menuItemFlat.setText("Flat Master");
        menuItemFlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFlatActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemFlat);

        jMenuBar1.add(menuMaster);

        jMenu2.setText("Help");

        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(checkTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkTenant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerateActionPerformed
        String type = types[cbType.getSelectedIndex()];
        Flat flat = flats.get(cbFlatNo.getSelectedIndex());
        String fromMonthYear = cbMonth.getSelectedItem() + " " + cbYear.getSelectedItem();        
        String toMonthYear = cbToMonth.getSelectedItem() + " " + cbToYear.getSelectedItem();

        System.out.println(fromMonthYear + " - " + toMonthYear);
        
        if (type.equalsIgnoreCase("Fixed")) {      
            if(fromMonthYear.equals(toMonthYear)) {
                int parkingSlots = Integer.parseInt(cbParking.getSelectedItem().toString());

                BillFrame billFrame = new BillFrame(flat, fromMonthYear, checkTenant.isSelected(), false, parkingSlots);
                billFrame.setVisible(true);
            } else {
                ManualBillFrame billFrame = new ManualBillFrame(flat, fromMonthYear, toMonthYear, false);
                billFrame.setVisible(true);
            }
        } else if (type.equalsIgnoreCase("Variable")) {
            JOptionPane.showMessageDialog(this, "Variable option not supported yet", "Upsupported Option", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btGenerateActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemChargeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemChargeTypeActionPerformed
        ChargeTypeFrame chargeTypeFrame = new ChargeTypeFrame(this);
        chargeTypeFrame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menuItemChargeTypeActionPerformed

    private void menuItemFlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFlatActionPerformed
        FlatFrame flatFrame = new FlatFrame(this);
        flatFrame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menuItemFlatActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        JOptionPane.showMessageDialog(this, "Author: Bilesh Ganguly\nDate: 2017-06-26", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    private void menuItemConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConfigActionPerformed
        ConfigFrame configFrame = new ConfigFrame(this);
        configFrame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menuItemConfigActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String type = types[cbType.getSelectedIndex()];
        Flat flat = flats.get(cbFlatNo.getSelectedIndex());
        String fromMonthYear = cbMonth.getSelectedItem() + " " + cbYear.getSelectedItem();
        String toMonthYear = cbToMonth.getSelectedItem() + " " + cbToYear.getSelectedItem();

        System.out.println(fromMonthYear + " - " + toMonthYear);
        
        if (type.equalsIgnoreCase("Fixed")) {          
            if(fromMonthYear.equals(toMonthYear)) {
                int parkingSlots = Integer.parseInt(cbParking.getSelectedItem().toString());

                BillFrame billFrame = new BillFrame(flat, fromMonthYear, checkTenant.isSelected(), true, parkingSlots);
                billFrame.setVisible(true);
            } else {
                ManualBillFrame billFrame = new ManualBillFrame(flat, fromMonthYear, toMonthYear, true);
                billFrame.setVisible(true);
            }
        } else if (type.equalsIgnoreCase("Variable")) {
            JOptionPane.showMessageDialog(this, "Variable option not supported yet", "Upsupported Option", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGenerate;
    private javax.swing.JComboBox<String> cbFlatNo;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbParking;
    private javax.swing.JComboBox<String> cbToMonth;
    private javax.swing.JComboBox<String> cbToYear;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JCheckBox checkTenant;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelFlatNo;
    private javax.swing.JLabel labelType;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemChargeType;
    private javax.swing.JMenuItem menuItemConfig;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemFlat;
    private javax.swing.JMenu menuMaster;
    // End of variables declaration//GEN-END:variables

    private void init() {
        populateFlatDropDown();

        String[] yearList = new String[10];
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int idx = 0; idx < 10; idx++) {
            yearList[idx] = Integer.toString(currentYear - idx);
        }
        DefaultComboBoxModel<String> fromYearModel = new DefaultComboBoxModel<>(yearList);
        cbYear.setModel(fromYearModel);        
        DefaultComboBoxModel<String> toYearModel = new DefaultComboBoxModel<>(yearList);
        cbToYear.setModel(toYearModel);

        cbFlatNo.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
    }

    public void populateFlatDropDown() {
        databaseConnection = new DatabaseConnection();
        if (databaseConnection.connect()) {
            dbFlat = new FlatDaoImpl(databaseConnection);
            flats = dbFlat.getAll();

            flatNumbers = new String[flats.size()];
            for (int i = 0; i < flats.size(); i++) {
                flatNumbers[i] = flats.get(i).getFlatNumber();
            }

            ComboBoxModel spinnerModel = new DefaultComboBoxModel(flatNumbers);
            cbFlatNo.setModel(spinnerModel);

            databaseConnection.disconnect();
        }
    }
}