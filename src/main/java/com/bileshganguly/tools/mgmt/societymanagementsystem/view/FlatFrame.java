/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bileshganguly.tools.mgmt.societymanagementsystem.view;

import com.bileshganguly.tools.mgmt.societymanagementsystem.dao.impl.FlatDaoImpl;
import com.bileshganguly.tools.mgmt.societymanagementsystem.model.Flat;
import com.bileshganguly.tools.mgmt.societymanagementsystem.sql.DatabaseConnection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bilesh
 */
public class FlatFrame extends JFrame {

    private final MainFrame parent;

    private DatabaseConnection databaseConnection;
    private FlatDaoImpl dbFlat;

    private final String[] fieldList = new String[]{"ID", "Flat Number", "Name", "Phone No.", "Email ID", "Area"};

    private List<Flat> flats = new LinkedList<>();
    private FlatModel dataModel;

    /**
     * Creates new form FlatFrame
     */
    public FlatFrame() {
        this.parent = null;
        initComponents();
        init();
    }

    public FlatFrame(MainFrame parent) {
        this.parent = parent;
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

        labelFlatNumber = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelArea = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        txtFlatNumber = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        btClear = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flat");

        labelFlatNumber.setText("Flat Number");

        labelEmail.setText("Email ID");

        labelArea.setText("Area");

        txtId.setEditable(false);

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            null,
            fieldList
        ));
        jScrollPane1.setViewportView(tblView);

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        labelId.setText("ID");

        btClear.setText("Clear");
        btClear.setToolTipText("");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        labelName.setText("Name");

        jLabel1.setText("Phone No.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFlatNumber)
                            .addComponent(labelEmail)
                            .addComponent(labelId)
                            .addComponent(labelArea)
                            .addComponent(labelName)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhone)
                            .addComponent(txtFlatNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtId)))
                    .addComponent(btAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFlatNumber)
                            .addComponent(txtFlatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelName)
                            .addComponent(txtName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btClear)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        if (validateFields()) {
            Flat flat = new Flat();
            flat.setFlatNumber(txtFlatNumber.getText());
            flat.setName(txtName.getText());
            flat.setEmailId(txtEmailId.getText());
            flat.setPhoneNo(txtPhone.getText());
            flat.setArea(Double.parseDouble(txtArea.getText()));
            if (dbFlat.insert(flat)) {
                flats.add(flat);
                clear();
                refreshTable();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please check the values in the fields."
                    + "\n- None of the fields (except for email) can be empty."
                    + "\n- The area field only takes numbers."
                    + "\n- You must input a valid email."
                    + "\n- You must input a valid phone number.",
                    "Invalid Value in fields",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        if (validateFields()) {
            Flat flat = new Flat();
            flat.setFlatId(Integer.parseInt(txtId.getText()));
            flat.setFlatNumber(txtFlatNumber.getText());
            flat.setName(txtName.getText());
            flat.setEmailId(txtEmailId.getText());
            flat.setPhoneNo(txtPhone.getText());
            flat.setArea(Double.parseDouble(txtArea.getText()));
            if (dbFlat.update(flat)) {
                int idx = tblView.getSelectedRow();
                flats.set(idx, flat);
                clear();
                refreshTable();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please check the values in the fields."
                    + "\n- None of the fields (except for email) can be empty."
                    + "\n- The area field only takes numbers."
                    + "\n- You must input a valid email."
                    + "\n- You must input a valid phone number.",
                    "Invalid Value in fields",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        clear();
    }//GEN-LAST:event_btClearActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (tblView.getSelectedRow() >= 0 && !txtId.getText().isEmpty()) {
            Flat flat = new Flat();
            flat.setFlatId(Integer.parseInt(txtId.getText()));
            flat.setFlatNumber(txtFlatNumber.getText());
            flat.setName(txtName.getText());
            flat.setEmailId(txtEmailId.getText());
            flat.setPhoneNo(txtPhone.getText());
            flat.setArea(Double.parseDouble(txtArea.getText()));
            if (dbFlat.delete(flat)) {
                int idx = tblView.getSelectedRow();
                flats.remove(idx);
                clear();
                refreshTable();
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(FlatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FlatFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFlatNumber;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelName;
    private javax.swing.JTable tblView;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtFlatNumber;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private class FlatModel extends AbstractTableModel {

        private final List<Flat> contents;
        private final String[] columns;

        public FlatModel(List<Flat> contents, String[] columns) {
            this.contents = contents;
            this.columns = columns;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        @Override
        public int getRowCount() {
            return this.contents.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return Integer.class;
                case 5:
                    return Double.class;
                default:
                    return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            Flat flat = contents.get(row);

            switch (column) {
                case 0:
                    return flat.getFlatId();
                case 1:
                    return flat.getFlatNumber();
                case 2:
                    return flat.getName();
                case 3:
                    return flat.getPhoneNo();
                case 4:
                    return flat.getEmailId();
                case 5:
                    return flat.getArea();
                default:
                    return "N/A";
            }
        }

    }

    private boolean validateFields() {
        return validateEmpty() && validateEmail() && validatePhone() && validateDouble();
    }

    private boolean validateEmpty() {
        return !txtFlatNumber.getText().isEmpty()
                && !txtName.getText().isEmpty()
                //&& !txtEmailId.getText().isEmpty()
                && !txtPhone.getText().isEmpty()
                && !txtArea.getText().isEmpty();
    }

    private boolean validateDouble() {
        try {
            double d = Double.parseDouble(txtArea.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        if (txtEmailId.getText().isEmpty()) {
            return true;
        } else {
            Pattern pattern;
            Matcher matcher;

            String EMAIL_PATTERN
                    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            pattern = Pattern.compile(EMAIL_PATTERN);

            matcher = pattern.matcher(txtEmailId.getText());
            return matcher.matches();
        }
    }

    private boolean validatePhone() {
        Pattern pattern;
        Matcher matcher;

        String PHONE_PATTERN
                = "^(\\+91\\d{10}|0\\d{10}|\\d{10})$";

        pattern = Pattern.compile(PHONE_PATTERN);

        matcher = pattern.matcher(txtPhone.getText());
        return matcher.matches();
    }

    private void init() {
        databaseConnection = new DatabaseConnection();
        if (databaseConnection.connect()) {
            dbFlat = new FlatDaoImpl(databaseConnection);
            populateList();
        }

        tblView.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (e.getValueIsAdjusting()) {
                return;
            }

            final DefaultListSelectionModel target = (DefaultListSelectionModel) e.getSource();
            int isSelectedIndex = target.getAnchorSelectionIndex();

            setFields(isSelectedIndex);
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (parent != null) {
                    parent.populateFlatDropDown();
                }
                databaseConnection.disconnect();
                if (parent != null) {
                    parent.setEnabled(true);
                }
            }
        });
    }

    private void clear() {
        tblView.clearSelection();

        txtArea.setText("");
        txtEmailId.setText("");
        txtPhone.setText("");
        txtId.setText("");
        txtFlatNumber.setText("");
        txtName.setText("");
    }

    private void setFields(int idx) {
        if (idx >= 0 && idx < flats.size()) {
            Flat flat = flats.get(idx);

            txtArea.setText(String.format("%.2f", flat.getArea()));
            txtEmailId.setText(flat.getEmailId());
            txtPhone.setText(flat.getPhoneNo());
            txtId.setText(Integer.toString(flat.getFlatId()));
            txtFlatNumber.setText(flat.getFlatNumber());
            txtName.setText(flat.getName());
        }
    }

    private void populateList() {
        flats = dbFlat.getAll();
        dataModel = new FlatModel(flats, fieldList);
        tblView.setModel(dataModel);
    }

    private void refreshTable() {
        dataModel.fireTableDataChanged();
    }
}
