package UI.CourseInstructor;

import BLL.CourseBLL;
import BLL.CourseIntructorBLL;
import BLL.TeacherBLL;
import DAL.Course.Course;
import DAL.CourseInstructor.CourseInstructor;
import DAL.Teacher.Teacher;
import static UI.CourseInstructor.CourseInstructorForm.IDS;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CourseInstructorEditForm extends javax.swing.JFrame {

    CourseIntructorBLL c = new CourseIntructorBLL();
    TeacherBLL t = new TeacherBLL();
    CourseBLL cbll = new CourseBLL();
    CourseInstructorForm home;

    public CourseInstructorEditForm(CourseInstructorForm parent, boolean modal) {

        initComponents();
        loadCombobox();
        home = parent;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(parent.DISPOSE_ON_CLOSE);
                parent.setVisible(!modal);
            }
        });
    }

    private void loadCombobox() {
        List<Teacher> listT;
        List<Course> listC;

        try {
            listT = t.LoadTeachers(1);
            listC = cbll.LoadCourses(1); 

            int CourseID = Integer.parseInt(IDS.split("\\|")[0]);

            int PersonID = Integer.parseInt(IDS.split("\\|")[1]);

            for (int i = 0; i < listT.size(); i++) {

                comboBoxSuggestion3.addItem(listT.get(i).getPersonID());
                comboBoxSuggestion4.addItem(listT.get(i).getFirstName() + listT.get(i).getLastName() + "");
                if (listT.get(i).getPersonID() == PersonID) {
                    comboBoxSuggestion3.setSelectedItem(listT.get(i).getPersonID());
                    comboBoxSuggestion4.setSelectedItem(listT.get(i).getFirstName()
                            + " " + listT.get(i).getLastName() + "");
                }
            }
            for (int i = 0; i < listC.size(); i++) {
                comboBoxSuggestion1.addItem(listC.get(i).getCourseID()+"");
                comboBoxSuggestion2.addItem(listC.get(i).getTitle()+"");
                if (listC.get(i).getCourseID() == CourseID) {
                    comboBoxSuggestion1.setSelectedItem(listC.get(i).getCourseID());
                    comboBoxSuggestion2.setSelectedItem(listC.get(i).getTitle());
                }
            }
            //fake
          
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        myButton1 = new UI.UI_Item.button.MyButton();
        myButton2 = new UI.UI_Item.button.MyButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxSuggestion4 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSuggestion3 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxSuggestion2 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new UI.UI_Item.combobox.ComboBoxSuggestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT INSTRUCTOR");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.GridBagLayout());

        myButton1.setText("EDIT");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 200);
        jPanel1.add(myButton1, gridBagConstraints);

        myButton2.setBackground(new java.awt.Color(255, 255, 255));
        myButton2.setForeground(new java.awt.Color(12, 105, 172));
        myButton2.setText("BACK");
        myButton2.setBorderColor(new java.awt.Color(12, 105, 172));
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 10;
        jPanel1.add(myButton2, gridBagConstraints);

        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        jLabel6.setText("Teacher Name");
        jPanel12.add(jLabel6);

        comboBoxSuggestion4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion4ItemStateChanged(evt);
            }
        });
        jPanel12.add(comboBoxSuggestion4);

        jPanel11.setLayout(new java.awt.GridLayout(2, 0));

        jLabel5.setText("Person ID");
        jPanel11.add(jLabel5);

        comboBoxSuggestion3.setEnabled(false);
        comboBoxSuggestion3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion3ItemStateChanged(evt);
            }
        });
        comboBoxSuggestion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxSuggestion3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboBoxSuggestion3MouseReleased(evt);
            }
        });
        jPanel11.add(comboBoxSuggestion3);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setText("Title Name");
        jPanel10.add(jLabel4);

        comboBoxSuggestion2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion2ItemStateChanged(evt);
            }
        });
        jPanel10.add(comboBoxSuggestion2);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Title ID");
        jPanel9.add(jLabel3);

        comboBoxSuggestion1.setEnabled(false);
        jPanel9.add(comboBoxSuggestion1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed

        int result = -1;
        int CourseID = Integer.parseInt(IDS.split("\\|")[0]);
        int PersonID = Integer.parseInt(IDS.split("\\|")[1]);
        int newCourseID = Integer.parseInt(comboBoxSuggestion1.getSelectedItem().toString());
        int newPersonID = Integer.parseInt(comboBoxSuggestion3.getSelectedItem().toString());

        try {
            if (CourseID == newCourseID && PersonID == newPersonID) {
                JOptionPane.showMessageDialog(this,
                        "Old CourseInstruction", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (CourseID != newCourseID || PersonID != newCourseID) {
                try {

                    result = c.updateCourseInstructor(
                            new CourseInstructor(newCourseID, newPersonID), 
                            new CourseInstructor(CourseID, PersonID)
                    );
                   
                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorAddForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (result > 0) {
                    IDS = newCourseID + "|" + newPersonID+ "";
                    JOptionPane.showMessageDialog(this,
                            "You have completed to edit Course Instrustor successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    home.listCourseInstructorForm();
                } else if (result == -2) {

                    JOptionPane.showMessageDialog(this,
                            "You haven't completed to edit Course Instrustion! foregin key", "Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Error different", "Message", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        this.dispose();
        home.initTable();
//        CourseInstructorForm c = new CourseInstructorForm();
//        c.setVisible(true);
    }//GEN-LAST:event_myButton2ActionPerformed

    private void comboBoxSuggestion3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxSuggestion3MouseReleased
    }//GEN-LAST:event_comboBoxSuggestion3MouseReleased

    private void comboBoxSuggestion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxSuggestion3MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion3MouseClicked

    private void comboBoxSuggestion3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion3ItemStateChanged
//        List<Teacher> listT = null;
//        try {
//            listT = t.LoadTeachers(1);
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        int PersonID = Integer.parseInt(comboBoxSuggestion3.getSelectedItem().toString());
//        for (int i = 0; i < listT.size(); i++) {
//            if (listT.get(i).getPersonID() == PersonID) {
//                comboBoxSuggestion4.setSelectedItem(listT.get(i).getFirstName()
//                        + " " + listT.get(i).getLastName() + "");
//            }
//        }
    }//GEN-LAST:event_comboBoxSuggestion3ItemStateChanged

    private void comboBoxSuggestion4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion4ItemStateChanged
          List<Teacher> listT = null;
        try {
            listT = t.LoadTeachers(1);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = comboBoxSuggestion4.getSelectedIndex();
        for (int i = 0; i < listT.size(); i++) {
            if (i == index) {
                comboBoxSuggestion3.setSelectedItem(listT.get(i).getPersonID());
            }
        }
    }//GEN-LAST:event_comboBoxSuggestion4ItemStateChanged

    private void comboBoxSuggestion2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion2ItemStateChanged
        List<Course> listC = null;
        try {
            listC = cbll.LoadCourses(1);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (comboBoxSuggestion2.getSelectedIndex() == -1) {
            System.out.println(comboBoxSuggestion2.getSelectedIndex());
        } else {
            int index = comboBoxSuggestion2.getSelectedIndex();
            for (int i = 0; i < listC.size(); i++) {
                if (i == index) {
                    comboBoxSuggestion1.setSelectedItem(listC.get(i).getCourseID());
                }
            }
        }
    }//GEN-LAST:event_comboBoxSuggestion2ItemStateChanged
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CourseInstructorEditForm EDIT_Course;
                EDIT_Course = new CourseInstructorEditForm(new CourseInstructorForm(), true);
                EDIT_Course.setVisible(true);
            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion1;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion2;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion3;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private UI.UI_Item.button.MyButton myButton1;
    private UI.UI_Item.button.MyButton myButton2;
    // End of variables declaration//GEN-END:variables
}
