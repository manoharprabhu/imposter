/*
 * The MIT License
 *
 * Copyright 2016 mprabhu.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.manoharprabhu;

import com.manoharprabhu.services.DataStore;
import java.awt.Component;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author mprabhu
 */
public class NumberConfigurationForm extends javax.swing.JFrame {

    /**
     * Creates new form NumberConfigurationForm
     */
    private String columnToBeConfigured = null;
    Long val = Long.MAX_VALUE;
    Long min = Long.MIN_VALUE;
    Long max = Long.MAX_VALUE;
    Long step = 1L;

    public NumberConfigurationForm() {
        initComponents();
    }

    public NumberConfigurationForm(String column) {
        this.columnToBeConfigured = column;
        initComponents();
        loadSavedValuesIfPresent();
    }

    public final void loadSavedValuesIfPresent() {
        Map<String, String> columnMap = DataStore.getMapForColumn(columnToBeConfigured);
        if (columnMap.get("isRandomNumber") != null) {
            if ("0".equals(columnMap.get("isRandomNumber"))) {
                isRandomCheckbox.setSelected(false);
                startingValueSpinner.setEnabled(true);
            } else {
                isRandomCheckbox.setSelected(true);
                startingValueSpinner.setEnabled(false);
            }
        } else {
            isRandomCheckbox.setSelected(false);
        }
        if (columnMap.get("minimumValue") != null) {
            minimumValueSpinner.setValue(Long.valueOf(columnMap.get("minimumValue")));
        } else {
            minimumValueSpinner.setValue(0L);
        }

        if (columnMap.get("maximumValue") != null) {
            maximumValueSpinner.setValue(Long.valueOf(columnMap.get("maximumValue")));
        } else {
            maximumValueSpinner.setValue(100L);
        }

        if (columnMap.get("startingValue") != null) {
            startingValueSpinner.setValue(Long.valueOf(columnMap.get("startingValue")));
        } else {
            startingValueSpinner.setValue(20L);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        isRandomCheckbox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minimumValueSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(val, min, max, step));
        jLabel2 = new javax.swing.JLabel();
        maximumValueSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(val, min, max, step));
        jLabel3 = new javax.swing.JLabel();
        startingValueSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(val, min, max, step));
        saveButton = new javax.swing.JButton();
        noValueCheckbox = new javax.swing.JCheckBox();

        jToggleButton1.setText("jToggleButton1");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        isRandomCheckbox.setText("Random number?");
        isRandomCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isRandomCheckboxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Range of value:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("To");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimumValueSpinner))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(maximumValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(minimumValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maximumValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Starting value:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        noValueCheckbox.setText("No value (NULL)");
        noValueCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noValueCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(noValueCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(isRandomCheckbox))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startingValueSpinner))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isRandomCheckbox)
                    .addComponent(noValueCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(startingValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String validationMessage = performValidation();
        if (validationMessage != null) {
            JOptionPane.showMessageDialog(this, validationMessage);
            return;
        }
        Map<String, String> columnMap = DataStore.getMapForColumn(columnToBeConfigured);
        columnMap.put("isRandomNumber", (isRandomCheckbox.isSelected() == true) ? "1" : "0");
        columnMap.put("minimumValue", String.valueOf(minimumValueSpinner.getValue()));
        columnMap.put("maximumValue", String.valueOf(maximumValueSpinner.getValue()));
        columnMap.put("startingValue", String.valueOf(startingValueSpinner.getValue()));
        columnMap.put("noValue", (noValueCheckbox.isSelected() == true) ? "1" : "0");
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void isRandomCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isRandomCheckboxActionPerformed
        if (isRandomCheckbox.isSelected()) {
            startingValueSpinner.setEnabled(false);
        } else {
            startingValueSpinner.setEnabled(true);
        }
    }//GEN-LAST:event_isRandomCheckboxActionPerformed

    private void setAllComponentState(boolean state) {
        isRandomCheckbox.setEnabled(state);
        minimumValueSpinner.setEnabled(state);
        maximumValueSpinner.setEnabled(state);
        startingValueSpinner.setEnabled(state);
    }
    private void noValueCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noValueCheckboxActionPerformed
        if (noValueCheckbox.isSelected()) {
            setAllComponentState(false);
        } else {
            setAllComponentState(true);
            isRandomCheckboxActionPerformed(evt);
        }
    }//GEN-LAST:event_noValueCheckboxActionPerformed

    public String performValidation() {
        Long minimumValue = (Long) minimumValueSpinner.getValue();
        Long maximumValue = (Long) maximumValueSpinner.getValue();
        Long startValue = (Long) startingValueSpinner.getValue();
        boolean isRandomValue = isRandomCheckbox.isSelected();
        if (maximumValue < minimumValue) {
            return "Please set the maximum value greater than or equal to the minimum value.";
        }

        if (!isRandomValue && (startValue > maximumValue || startValue < minimumValue)) {
            return "Please set the start value within the maximum and minimum value range.";
        }

        return null;
    }

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
            java.util.logging.Logger.getLogger(NumberConfigurationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberConfigurationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberConfigurationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberConfigurationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberConfigurationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox isRandomCheckbox;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JSpinner maximumValueSpinner;
    private javax.swing.JSpinner minimumValueSpinner;
    private javax.swing.JCheckBox noValueCheckbox;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner startingValueSpinner;
    // End of variables declaration//GEN-END:variables

}
