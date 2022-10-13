/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.CourseInstructor;

import DAL.CourseInstructor.CourseInstructor;
import BLL.CourseIntructorBLL;
import UI.MenuForm;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CourseInstructorForm extends javax.swing.JFrame {

    CourseIntructorBLL c = new CourseIntructorBLL();
    static String IDS = "";
    MenuForm home ;
    public CourseInstructorForm(MenuForm parrent, boolean modal) {
        initComponents();
        initTable();
        init();
        this.setLocationRelativeTo(null);
        this.home = parrent;
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(parrent.DISPOSE_ON_CLOSE);
                parrent.setVisible(true);
            }
        });
    }
    public CourseInstructorForm() {
        initComponents();
        initTable();
        init();
        this.setLocationRelativeTo(null);
        this.home = new MenuForm();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(home.DISPOSE_ON_CLOSE);
                home.setVisible(true);
            }
        });
        
    }

    public void init() {
        tableDark1.fixTable(jScrollPane1);
        getContentPane().setBackground(Color.white);
    }

    public void initTable() {
        try {
            listCourseInstructorForm();
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void listCourseInstructorForm() throws SQLException {
        List list = c.loadCourseInstructor();
        DefaultTableModel model = convertCourseInstructor(list);
        tableDark1.setModel(model);
    }

    private DefaultTableModel convertCourseInstructor(List list) throws SQLException {
        String[] columnNames = {"TT", "PERSONID", "NAME TEACHER", "COURSEID", "TITLE COURSE"};
        String[] teacherNames = c.loadTeacheName(list);
        String[] titles = c.loadTitle(list);
        Object[][] data;
        data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            CourseInstructor c = (CourseInstructor) list.get(i);
            data[i][0] = i + 1;
            data[i][1] = c.getPersonID();
            //courseBLL
            data[i][4] = titles[i];
            // personBLL
            data[i][2] = teacherNames[i];
            //nameteacher
            data[i][3] = c.getCourseID();

        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        searchField1 = new UI.UI_Item.textfield.SearchField();
        myButton1 = new UI.UI_Item.button.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new UI.UI_Item.table.TableDark();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        myButton2 = new UI.UI_Item.button.MyButton();
        myButton3 = new UI.UI_Item.button.MyButton();
        myButton4 = new UI.UI_Item.button.MyButton();
        jPanel9 = new javax.swing.JPanel();
        myButton5 = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Course Instructor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        searchField1.setText("search Course Instructor");
        searchField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchField1MouseClicked(evt);
            }
        });
        searchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 199;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 141, 0, 0);
        jPanel6.add(searchField1, gridBagConstraints);

        myButton1.setText("SEARCH");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 152, 7, 53);
        jPanel6.add(myButton1, gridBagConstraints);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDark1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        myButton2.setBackground(new java.awt.Color(93, 212, 253));
        myButton2.setText("ADD");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(myButton2, gridBagConstraints);

        myButton3.setBackground(new java.awt.Color(0, 161, 255));
        myButton3.setText("EDIT");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(myButton3, gridBagConstraints);

        myButton4.setBackground(new java.awt.Color(12, 105, 172));
        myButton4.setText("DELETE");
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel8.add(myButton4, gridBagConstraints);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        myButton5.setBackground(new java.awt.Color(255, 255, 255));
        myButton5.setForeground(new java.awt.Color(12, 105, 172));
        myButton5.setText("BACK");
        myButton5.setBorderColor(new java.awt.Color(12, 105, 172));
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField1ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
       // load laji truoc khi search
       try {
           listCourseInstructorForm();
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        String stringToSearchs = searchField1.getText();
        try {
           
            List list = c.findCourseInstructor(stringToSearchs);
            DefaultTableModel model = convertCourseInstructor(list);
            tableDark1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        CourseInstructorAddForm C_ADD_FORM = new CourseInstructorAddForm(this, false);
        C_ADD_FORM.setVisible(true);
        C_ADD_FORM.setLocationRelativeTo(null);
//        this.setVisible(false);
//        this.dispose();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed

        if (tableDark1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pleases choose row!", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                List<CourseInstructor> list = c.loadCourseInstructor();
                IDS = list.get(tableDark1.getSelectedRow()).getCourseID() + "|"
                        + list.get(tableDark1.getSelectedRow()).getPersonID() + "";
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            CourseInstructorEditForm C_EDIT_FORM = new CourseInstructorEditForm(this, false);
            C_EDIT_FORM.setVisible(true);
            C_EDIT_FORM.setLocationRelativeTo(null);
//      this.setVisible(false);
//            this.dispose();
        }


    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        if (tableDark1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "chose row!", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "You want delete this row",
                    "Yes",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    List<CourseInstructor> list = c.loadCourseInstructor();
                    int result = c.deleteCourseInstructor(new CourseInstructor(list.get(tableDark1.getSelectedRow()).getCourseID(),
                            list.get(tableDark1.getSelectedRow()).getPersonID()));
                    if (result == -1) {
                        JOptionPane.showMessageDialog(this,
                                "Deleted fail!", "Message", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Deleted success!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        initTable();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 

        }

    }//GEN-LAST:event_myButton4ActionPerformed

    private void searchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchField1MouseClicked
        searchField1.setText("");
    }//GEN-LAST:event_searchField1MouseClicked

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
         home.setVisible(true);
         this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton5ActionPerformed

//    public static void main(String args[]) {
//       
//        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseInstructorForm().setVisible(true);
            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.UI_Item.button.MyButton myButton1;
    private UI.UI_Item.button.MyButton myButton2;
    private UI.UI_Item.button.MyButton myButton3;
    private UI.UI_Item.button.MyButton myButton4;
    private UI.UI_Item.button.MyButton myButton5;
    private UI.UI_Item.textfield.SearchField searchField1;
    private UI.UI_Item.table.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables

}
