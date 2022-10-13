package UI.CourseInstructor;

import BLL.CourseBLL;
import BLL.CourseIntructorBLL;
import BLL.TeacherBLL;
import DAL.Course.Course;
import DAL.CourseInstructor.CourseInstructor;
import DAL.Teacher.Teacher;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CourseInstructorAddForm extends javax.swing.JFrame {
    static int count = 0;

    CourseInstructorForm home;
    CourseIntructorBLL c = new CourseIntructorBLL();
    TeacherBLL t = new TeacherBLL();
    CourseBLL cbll = new CourseBLL();

    public CourseInstructorAddForm(CourseInstructorForm parent, boolean modal) {

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
            for (int i = 0; i < listT.size(); i++) {
                personIDCBB.addItem(listT.get(i).getPersonID());
                teacherNameCBB.addItem(listT.get(i).getFirstName() + listT.get(i).getLastName() + "");
            }
            for (int j = 0; j < listC.size(); j++) {
                comboBoxSuggestion1.addItem(listC.get(j).getCourseID());
                comboBoxSuggestion2.addItem(listC.get(j).getTitle());
            }
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
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxSuggestion2 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        personIDCBB = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        teacherNameCBB = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel1 = new javax.swing.JPanel();
        myButton1 = new UI.UI_Item.button.MyButton();
        myButton2 = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD INSTRUCTOR");

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

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Course ID");
        jPanel9.add(jLabel3);

        comboBoxSuggestion1.setEnabled(false);
        comboBoxSuggestion1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion1ItemStateChanged(evt);
            }
        });
        comboBoxSuggestion1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboBoxSuggestion1PropertyChange(evt);
            }
        });
        jPanel9.add(comboBoxSuggestion1);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setText("Title Name");
        jPanel10.add(jLabel4);

        comboBoxSuggestion2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion2ItemStateChanged(evt);
            }
        });
        jPanel10.add(comboBoxSuggestion2);

        jPanel11.setLayout(new java.awt.GridLayout(2, 0));

        jLabel5.setText("Person ID");
        jPanel11.add(jLabel5);

        personIDCBB.setEnabled(false);
        personIDCBB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                personIDCBBItemStateChanged(evt);
            }
        });
        jPanel11.add(personIDCBB);

        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        jLabel6.setText("Teacher Name");
        jPanel12.add(jLabel6);

        teacherNameCBB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                teacherNameCBBItemStateChanged(evt);
            }
        });
        jPanel12.add(teacherNameCBB);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        myButton1.setText("ADD");
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

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        this.dispose();
//        CourseInstructorForm c = new CourseInstructorForm();
//        c.setVisible(true);
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        int result = -1;
        try {

            result = c.addCourseInstructor(
                    new CourseInstructor(
                            Integer.parseInt(comboBoxSuggestion1.getSelectedItem().toString()),
                            Integer.parseInt(personIDCBB.getSelectedItem().toString())
                    )
            );
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "You have completed to add Course Instruction successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                home.setVisible(true);
                home.initTable();
                this.dispose();

            } else if (result == -2) {

                JOptionPane.showMessageDialog(this,
                        "Cannot add due to duplicate course ID and person ID", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "can't add data", "Message", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void personIDCBBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_personIDCBBItemStateChanged
//        List<Teacher> listT = null;
//                count  = count + 1;
//                System.out.println("change +" + count);
//                    System.out.println("box 3 change");
//
//        try {
//            listT = t.LoadTeachers(1);
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        int PersonID = Integer.parseInt(personIDCBB.getSelectedItem().toString());
//        for (int i = 0; i < listT.size(); i++) {
//            if (listT.get(i).getPersonID() == PersonID) {
//                teacherNameCBB.setSelectedItem(listT.get(i).getFirstName()
//                        + " " + listT.get(i).getLastName() + "");
//            }
//        }
    }//GEN-LAST:event_personIDCBBItemStateChanged

    private void teacherNameCBBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_teacherNameCBBItemStateChanged
        List<Teacher> listT = null;
        try {
            listT = t.LoadTeachers(1);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = teacherNameCBB.getSelectedIndex();
        for (int i = 0; i < listT.size(); i++) {
            if (i == index) {
                personIDCBB.setSelectedItem(listT.get(i).getPersonID());
            }
        }
    }//GEN-LAST:event_teacherNameCBBItemStateChanged

    //done
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

    private void comboBoxSuggestion1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion1ItemStateChanged
//        List<Course> listC = null;
//        try {
//            listC = cbll.LoadCourses(1);
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            System.out.println("box 1 change");
//
//        int CourseID = 0;
//        if (comboBoxSuggestion1.getSelectedIndex() == -1) {
//            System.out.println("not selecte");
//        } else {
//            CourseID = Integer.parseInt(comboBoxSuggestion1.getSelectedItem().toString());
//            System.out.println(CourseID);
//            for (int i = 0; i < listC.size(); i++) {
//                int selectID = listC.get(i).getCourseID();
//                if(selectID == CourseID) {
//                    System.out.println("equa");
//                    System.out.println(listC.get(i).getTitle());
//                    comboBoxSuggestion2.setSelectedItem(listC.get(i).getTitle());
//                    break;
//                } else {
//                }
//            }
//        }
    }//GEN-LAST:event_comboBoxSuggestion1ItemStateChanged

    private void comboBoxSuggestion1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboBoxSuggestion1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion1PropertyChange
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
//            java.util.logging.Logger.getLogger(CourseInstructorAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CourseInstructorAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CourseInstructorAddForm ADD_Course;
                ADD_Course = new CourseInstructorAddForm(new CourseInstructorForm(), true);
                ADD_Course.setVisible(true);
            }
//        });
//
//    }

    //close

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion1;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion2;
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
    private UI.UI_Item.combobox.ComboBoxSuggestion personIDCBB;
    private UI.UI_Item.combobox.ComboBoxSuggestion teacherNameCBB;
    // End of variables declaration//GEN-END:variables
}
