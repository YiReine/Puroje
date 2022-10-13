package UI.Course;

import BLL.Course.DepartmentBLL;
import BLL.Course.OnsiteCourseBLL;
import DAL.Course.OnsiteCourse;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OnsiteCourseForm extends javax.swing.JFrame {

    OnsiteCourseBLL osbll;
    DepartmentBLL dpbll = new DepartmentBLL();

    public OnsiteCourseForm() {
        this.setTitle("OnsiteCourse");
        osbll = new OnsiteCourseBLL();
        initComponents();
        tbDS.fixTable(jScrollPane1);
        getContentPane().setBackground(Color.WHITE);
        try {
            listOs();
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //for 3layer`
    private DefaultTableModel convertOs(List list) throws SQLException {
        String[] columnNames = {"STT", "CourseID", "Title", "Credits", "DepartmentID", "Location", "Days", "Time"};
        Object[][] data = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            OnsiteCourse os = (OnsiteCourse) list.get(i);
            data[i][0] = i + 1;
            data[i][1] = os.getCourseID();
            data[i][2] = os.getTitle();
            data[i][3] = os.getCredits();
            data[i][4] = dpbll.getDepartmentName(os.getDepartmentID());
            data[i][5] = os.getLocation();
            data[i][6] = os.getDays();
            data[i][7] = os.getTime();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    private void listOs() throws SQLException {
        List list = osbll.LoadOnsiteCourse(1);

        DefaultTableModel model = convertOs(list);
        tbDS.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new UI.UI_Item.textfield.SearchField();
        btnSaerch = new UI.UI_Item.button.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDS = new UI.UI_Item.table.TableDark();
        btnAdd = new UI.UI_Item.button.MyButton();
        btnEdit = new UI.UI_Item.button.MyButton();
        btnDelete = new UI.UI_Item.button.MyButton();
        btnBack = new UI.UI_Item.button.MyButton();
        btnReload = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 41, 54));
        jLabel1.setText("OnsiteCourse");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSaerch.setText("Search");
        btnSaerch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaerchMouseClicked(evt);
            }
        });

        tbDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PersonID", "FirstName", "LastName", "EnrollmentDate", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tbDS);

        btnAdd.setBackground(new java.awt.Color(93, 212, 253));
        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(12, 105, 172));
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setForeground(new java.awt.Color(12, 105, 172));
        btnBack.setText("Back");
        btnBack.setBorderColor(new java.awt.Color(12, 105, 172));
        btnBack.setColor(new java.awt.Color(255, 255, 255));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(93, 212, 253));
        btnReload.setText("Reload");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSaerch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        OnsiteCourseAddForm add = new OnsiteCourseAddForm();
        add.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int row = tbDS.getSelectedRow();
        TableModel model = tbDS.getModel();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please choose one row in table !", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            int CourseID = Integer.parseInt(model.getValueAt(row, 1).toString());
            OnsiteCourseEditForm f;
            try {
                f = new OnsiteCourseEditForm(CourseID);
                f.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        try {
            int row = tbDS.getSelectedRow();
            TableModel model = tbDS.getModel();

            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table !", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                int CourseID = Integer.parseInt(model.getValueAt(row, 1).toString());
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this OnsiteCourse?", "Warning!", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    if (osbll.deleteOnsiteCourse(CourseID) == 1) {
                        JOptionPane.showMessageDialog(this, "You have completed to delete onsite course successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        List list = osbll.LoadOnsiteCourse(1);
                        model = convertOs(list);
                        tbDS.setModel(model);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error for Informating binding!", "Message", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSaerchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaerchMouseClicked
        try {
            String Title = txtSearch.getText();
            if (Title.isBlank() == false) {
                List list = osbll.findOnsiteCourse(Title);
                DefaultTableModel model = convertOs(list);
                tbDS.setModel(model);

            } else {
                //JOptionPane.showMessageDialog(this, "fullname is empty", "Message", JOptionPane.ERROR_MESSAGE);
                List list = osbll.LoadOnsiteCourse(1);
                DefaultTableModel model = convertOs(list);
                tbDS.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaerchMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        OnsiteCourseForm main = new OnsiteCourseForm();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReloadMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(OnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnsiteCourseForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnAdd;
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnDelete;
    private UI.UI_Item.button.MyButton btnEdit;
    private UI.UI_Item.button.MyButton btnReload;
    private UI.UI_Item.button.MyButton btnSaerch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.UI_Item.table.TableDark tbDS;
    private UI.UI_Item.textfield.SearchField txtSearch;
    // End of variables declaration//GEN-END:variables
}
